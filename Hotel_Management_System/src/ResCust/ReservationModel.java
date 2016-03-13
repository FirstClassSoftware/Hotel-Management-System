/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResCust;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
//import testDatabase.*;

/**
 *
 * @author Whelan
 */
public class ReservationModel extends AbstractTableModel {
    
    private String host;
    private String username;
    private String password;
    private Connection con;
    private Statement stmt;
    private String SQL;
    private ResultSet rs;
    private String Database;
    private String table;
    
    private List<Reservation> Reservations;
    
    private String[] columnNames = new String[9];
    private Object[][] data;
    
    //private tstDatabase t;
    
    public ReservationModel() {
         
        try {
            
            //t = new tstDatabase();
            
            
        
            host = "jdbc:sqlite:hotelData.db";
            username = "student";
            password = "password";
        
            con = DriverManager.getConnection(host, username, password);
            stmt = con.createStatement( ResultSet.TYPE_FORWARD_ONLY, 
                    ResultSet.CONCUR_READ_ONLY);
            
            //SQL = "CREATE DATABASE APP";
            //stmt.executeUpdate(SQL);
            
            //SQL = "SELECT name FROM sqlite_master WHERE type='table' AND name='table_name'";
            //stmt.executeUpdate(SQL);
            
            SQL = "CREATE TABLE IF NOT EXISTS RESERVATIONS" +
                    "(ID INT PRIMARY KEY     NOT NULL,"
                    + "FLOOR_NUMBER VARCHAR(255),"
                    + "ROOM_NUMBER VARCHAR(255),"
                    + "START_DATE VARCHAR(255),"
                    + "END_DATE VARCHAR(255),"
                    + "CUST_FIRST VARCHAR(255),"
                    + "CUST_LAST VARCHAR(255),"
                    + "ROOM_TYPE VARCHAR(255),"
                    + "COST DOUBLE)";
            stmt.executeUpdate(SQL);
                
            columnNames[0] = "Floor Number";
            columnNames[1] = "RoomNumber";
            columnNames[2] = "Start Date";
            columnNames[3] = "End Date";
            columnNames[4] = "Customer First Name";
            columnNames[5] = "Customer Last Name";
            columnNames[6] = "Room Type";
            columnNames[7] = "Cost";
        
            /*columnNames = {"Floor Number",
                        "Room Number",
                        "Start Date",
                        "End Date",
                        "Customer First Name",
                        "Customer Last Name",
                        "Room Type",
                        "Cost"};
            */     
            
            SQL = "select * from RESERVATIONS";
            rs = stmt.executeQuery(SQL);
            
          
            
           // String SQL = "DELETE TABLE ?";
             
           // PreparedStatement st = con.prepareStatement(SQL);
            //st.setString(1, table);
            //st.executeUpdate(); 
        }
                    
        
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
    } 
    
    
    
    public int getRowCount() {
        getReservations();
        return Reservations.size();
    }
    
    public int getColumnCount() {
        getReservations();
        return Reservations.get(0).getSize();
    }
    
    public Object getValueAt(int row, int column) {
        getReservations();
        return Reservations.get(row).get(column);
    }
    
    
    
    
    
    
    
    
    
    
    
    public int getNumRows() {
        int rows = 0;
        try {
            while(rs.next()) {
                rows++;
            }
            return rows;
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        return rows;
        
    }
    
    public void addNewReservation(String floorNum, String roomNum, String startDate, 
            String endDate, String custFirstName, String custLastName, String roomType, double cost) {
        
        int oldID;
        int newID = 0;
        try {
            SQL = "select * from RESERVATIONS";
            rs = stmt.executeQuery(SQL);
            if(!rs.isBeforeFirst()) {
                newID = 1;
            }
            else {
                while(rs.next()) {
                    oldID = rs.getInt("ID");
                    newID = oldID + 1;   
                }
            }
            stmt.executeUpdate("INSERT INTO RESERVATIONS (ID, FLOOR_NUMBER, ROOM_NUMBER,"
                    + "START_DATE, END_DATE, CUST_FIRST, CUST_LAST, ROOM_TYPE, COST)" 
                    + "VALUES ( " + newID + ", '" + floorNum + "', '" + roomNum + "', '"
                    + startDate + "', '" + endDate + "', '" + custFirstName + "', '" 
                    + custLastName + "', '" + roomType + "', " + cost + ")");
            
            //System.out.println("Successfully added to database");
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
    }
    
    public ResultSet getResultSet() {
        try {
            SQL = "select * from RESERVATIONS";
            rs = stmt.executeQuery(SQL);
            return rs;
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        return rs;
        
    }
    
    public List<Reservation> getReservations() {
        Reservations = new ArrayList<Reservation>();
        try {
            ResultSet result = getResultSet();
            
            
            while(result.next()) {
                Reservation reserve = new Reservation(rs.getInt("ID"), rs.getString("FLOOR_NUMBER"), 
                        rs.getString("ROOM_NUMBER"), rs.getString("START_DATE"), 
                        rs.getString("END_DATE"), rs.getString("CUST_FIRST"), 
                        rs.getString("CUST_LAST"), rs.getString("ROOM_TYPE"), rs.getDouble("COST"));
                Reservations.add(reserve);
            }
            
            
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
        return Reservations;
    }
    
    /*
    public Object[][] exportReservations(ArrayList<Reservation> reservations) {
        data = new Object[reservations.size()][reservations.get(0).getSize()];
        for (int i=0; i < reservations.size() ; i++) {
            data[i][0] = reservations.get(i).getID();
        }
    }
    */
    
    
    /*
    public String printReservations(ResultSet rs) {
        StringBuilder out = new StringBuilder();
        try {
            while(rs.next()) {
                int idNum = rs.getInt("ID");
                String floorNum = rs.getString("FLOOR_NUMBER");
                String roomNum = rs.getString("ROOM_NUMBER");
                String startDate = rs.getString("START_DATE");
                String endDate = rs.getString("END_DATE");
                String custFirst = rs.getString("CUST_FIRST");
                String custLast = rs.getString("CUST_LAST");
                String roomType = rs.getString("ROOM_TYPE");
                double cost = rs.getDouble("COST");
                out.append(idNum + " " + floorNum + " " + roomNum + " " + startDate + " " 
                        + endDate + " " + custFirst + " " + custLast + " " 
                        + roomType +  " " + cost);
                out.append("\n");
            }
            return out.toString();
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        return "SQL Error";
    }
    
    
    
    public String printReservationsIDSort() {
        try {
            SQL = "select * from RESERVATIONS";
            rs = stmt.executeQuery(SQL);
            return printReservations(rs);
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        return "SQL Error";
    }
    
    */
    
}
