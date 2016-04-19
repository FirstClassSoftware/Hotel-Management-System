/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservationModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

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
    
    private List<Reservation> Reservations;
    
    private final String[] columnNames = new String[] {"ID", "Floor Number", 
        "Room Number", "Start Date", "End Date", "Customer First Name", 
        "Customer Last Name", "Room Type", "Cost"};
    
    public ReservationModel() {
         
        try {
            
            host = "jdbc:sqlite:hotelData.db";
            username = "";
            password = "";
        
            con = DriverManager.getConnection(host, username, password);
            stmt = con.createStatement( ResultSet.TYPE_FORWARD_ONLY, 
                    ResultSet.CONCUR_READ_ONLY);
            
            SQL = "CREATE TABLE IF NOT EXISTS RESERVATIONS" 
                    + "(ID INT PRIMARY KEY     NOT NULL,"
                    + "FLOOR_NUMBER VARCHAR(255),"
                    + "ROOM_NUMBER VARCHAR(255),"
                    + "START_DATE VARCHAR(255),"
                    + "END_DATE VARCHAR(255),"
                    + "CUST_FIRST VARCHAR(255),"
                    + "CUST_LAST VARCHAR(255),"
                    + "ROOM_TYPE VARCHAR(255),"
                    + "COST DOUBLE)";
            stmt.executeUpdate(SQL);
            
            SQL = "select * from RESERVATIONS";
            rs = stmt.executeQuery(SQL);
            
            //System.out.println("success");
            
        }
                    
        
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
    } 
    
    
    
    
    
    
    
    
    
    @Override
    public int getRowCount() {
        getReservations();
        return Reservations.size();
    }
    
    @Override
    public int getColumnCount() {
        getReservations();
        return 9;
        //return Reservations.get(0).getSize();
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        getReservations();
        return Reservations.get(row).get(column);
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        getReservations();
        Reservations.get(row).setValue(col, value);
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
            this.fireTableDataChanged();
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
        Reservations = new ArrayList<>();
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
    
    
    
    
    
    
    
    
    
    
    
    
    public void deleteRowFromTable(int id) {
        
        try {
            //row++;
            //int id = Reservations.get(row).getID();
            stmt.executeUpdate("delete from RESERVATIONS WHERE ID = " + id);
            this.fireTableDataChanged();
            
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
    }
    
}
