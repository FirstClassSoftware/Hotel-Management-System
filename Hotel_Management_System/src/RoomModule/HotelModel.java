/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoomModule;

import CustomerModule.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Whelan
 */
public class HotelModel extends AbstractTableModel {
    
    private String host;
    private String username;
    private String password;
    private Connection con;
    private Statement stmt;
    private String SQL;
    private ResultSet rs;
    
    private List<Room> Rooms;
    
    private final String[] columnNames = new String[] {"ID", "Room Nubmer", "Room Type", 
        "Is Reserved?", "Reservation Start Date", "Reservation End Date"};
    
    private final String[] columnNamesSQL = new String[] {"ID", "ROOM_NUMBER", "ROOM_TYPE", 
        "RESERVED", "RESERVATION_START_DATE", "RESERVATION_END_DATE"};
    
    public HotelModel() {
         
        try {
            
            host = "jdbc:sqlite:hotelData.db";
            username = "";
            password = "";
        
            con = DriverManager.getConnection(host, username, password);
            stmt = con.createStatement( ResultSet.TYPE_FORWARD_ONLY, 
                    ResultSet.CONCUR_READ_ONLY);
            
            SQL = "CREATE TABLE IF NOT EXISTS HOTEL" 
                    + "(ID INT PRIMARY KEY     NOT NULL,"
                    + "ROOM_NUMBER INTEGER,"
                    + "ROOM_TYPE VARCHAR(255),"
                    + "RESERVED BOOLEAN,"
                    + "RESERVATION_START_DATE VARCHAR(255),"
                    + "RESERVATION_END_DATE VARCHAR(255))";
            stmt.executeUpdate(SQL);
            
            SQL = "select * from HOTEL";
            rs = stmt.executeQuery(SQL);
            
            System.out.println("table created");
            
        }
                    
        
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
    } 
    
    
    
    
    
    
    
    
    
    @Override
    public int getRowCount() {
        getRooms();
        return Rooms.size();
    }
    
    @Override
    public int getColumnCount() {
        getRooms();
        int columns = 11;
        return columns;
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        getRooms();
        return Rooms.get(row).get(column);
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        getRooms();
        //Customers.get(row).setValue(col, value);
        setRoomValue(value, row, col);
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }
    
    
    
    
    
    
    

    
    public String[] getColumnNames() {
        return columnNames;
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void addNewRoom(int roomNum, String roomType, Boolean isReserved, 
            String reservationStartDate, String reservationEndDate) {
        
        int oldID;
        int newID = 0;
        try {
            SQL = "select * from HOTEL";
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
            stmt.executeUpdate("INSERT INTO CUSTOMERS (ID, ROOM_NUMBER, ROOM_TYPE,"
                    + "RESERVED, RESERVATION_START_DATE, RESERVATION_END_DATE)" 
                    + "VALUES ( " + newID + ", '" + roomNum + "', '" + roomType + "', '"
                    + isReserved + "', '" + reservationStartDate + "', '" 
                    + reservationEndDate + "')");
            
            System.out.println("Successfully added to database");
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
        this.fireTableDataChanged();
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<Room> getRooms() {
        Rooms = new ArrayList<>();
        try {
            ResultSet result = this.getResultSet();
            
            while(result.next()) {
                Room getRoom = new Room(rs.getInt("ID"), rs.getInt("ROOM_NUMBER"), 
                        rs.getString("ROOM_TYPE"), rs.getBoolean("RESERVED"), 
                        rs.getString("RESERVATION_START_DATE"), rs.getString("RESERVATION_END_DATE"));
                Rooms.add(getRoom);
            }
            
            
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
        return Rooms;
    }
    
    public ResultSet getResultSet() {
        try {
            SQL = "select * from HOTEL";
            rs = stmt.executeQuery(SQL);
            return rs;
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        return rs;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void setRoomValue(Object value, int row, int column) {
        
        try {
            //UPDATE users SET role=99 WHERE name='Fred'
            if(column != 0) {
            int id = Rooms.get(row).getID();
            stmt.executeUpdate("UPDATE HOTEL SET " + columnNamesSQL[column] + " = '" + value + "' WHERE ID = " + id);
            }
            //System.out.println("Successfully updated value");
            
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
    }
    
    
    
    
    
    
    
    
    public void deleteRowFromTable(int id) {
        
        try {
            //row++;
            //int id = Customers.get(row).getID();
            stmt.executeUpdate("delete from HOTEL WHERE ID = " + id);
            this.fireTableDataChanged();
            
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
    }
    
    public void deleteAllFromTable() {
        
        try {
            stmt.executeUpdate("delete from HOTEL");
            
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
    }
    
}
