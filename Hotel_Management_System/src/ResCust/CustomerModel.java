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

/**
 *
 * @author Whelan
 */
public class CustomerModel extends AbstractTableModel {
    
    private String host;
    private String username;
    private String password;
    private Connection con;
    private Statement stmt;
    private String SQL;
    private ResultSet rs;
    
    private List<Customer> Customers;
    
    private final String[] columnNames = new String[] {"First Name", "Last Name", 
        "Number of Occupants", "Occupation Date", "Address", "Customer Tab", 
        "Previous Room Number", "Phone Number", "Email", "Payment Method"};
    
    public CustomerModel() {
         
        try {
            
            host = "jdbc:sqlite:hotelData.db";
            username = "student";
            password = "password";
        
            con = DriverManager.getConnection(host, username, password);
            stmt = con.createStatement( ResultSet.TYPE_FORWARD_ONLY, 
                    ResultSet.CONCUR_READ_ONLY);
            
            SQL = "CREATE TABLE IF NOT EXISTS CUSTOMERS" 
                    + "(ID INT PRIMARY KEY     NOT NULL,"
                    + "FIRST_NAME VARCHAR(255),"
                    + "LAST_NAME VARCHAR(255),"
                    + "NUMBER_OF_OCCUPANTS VARCHAR(255),"
                    + "OCCUPATION_DATE VARCHAR(255),"
                    + "ADDRESS VARCHAR(255),"
                    + "TAB VARCHAR(255),"
                    + "PREVIOUS_ROOM_NUM VARCHAR(255),"
                    + "PHONE_NUM VARCHAR(255),"
                    + "EMAIL VARCHAR(255),"
                    + "PAYMENT_METHOD VARCHAR(255))";
            stmt.executeUpdate(SQL);
            
            SQL = "select * from CUSTOMERS";
            rs = stmt.executeQuery(SQL);
            
            System.out.println("table created");
            
        }
                    
        
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
    } 
    
    
    
    
    
    
    
    
    
    @Override
    public int getRowCount() {
        getCustomers();
        return Customers.size();
    }
    
    @Override
    public int getColumnCount() {
        getCustomers();
        return 11;
        //return Customers.get(0).getSize();
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        getCustomers();
        return Customers.get(row).get(column);
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        getCustomers();
        Customers.get(row).setValue(col, value);
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
    
    public void addNewCustomer(String firstName, String lastName, String numOfOccupants, 
            String occupationDate, String address, String tab, String lastRoomNum, 
            String phoneNum, String email, String paymentMethod) {
        
        int oldID;
        int newID = 0;
        try {
            SQL = "select * from CUSTOMERS";
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
            stmt.executeUpdate("INSERT INTO CUSTOMERS (ID, FIRST_NAME, LAST_NAME,"
                    + "NUMBER_OF_OCCUPANTS, OCCUPATION_DATE, ADDRESS, TAB, "
                    + "PREVIOUS_ROOM_NUM, PHONE_NUM, EMAIL, PAYMENT_METHOD)" 
                    + "VALUES ( " + newID + ", '" + firstName + "', '" + lastName + "', '"
                    + numOfOccupants + "', '" + occupationDate + "', '" + address + "', '" 
                    + tab + "', '" + lastRoomNum + "', '" + phoneNum + "', '"
                    + email + "', '" + paymentMethod + "')");
            
            System.out.println("Successfully added to database");
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
    }
    
    public ResultSet getResultSet() {
        try {
            SQL = "select * from CUSTOMERS";
            rs = stmt.executeQuery(SQL);
            return rs;
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        return rs;
        
    }
    
    public List<Customer> getCustomers() {
        Customers = new ArrayList<Customer>();
        try {
            ResultSet result = this.getResultSet();
            
            while(result.next()) {
                Customer customer = new Customer(rs.getInt("ID"), rs.getString("FIRST_NAME"), 
                        rs.getString("LAST_NAME"), rs.getString("NUMBER_OF_OCCUPANTS"), 
                        rs.getString("OCCUPATION_DATE"), rs.getString("ADDRESS"), 
                        rs.getString("TAB"), rs.getString("PREVIOUS_ROOM_NUM"), 
                        rs.getString("PHONE_NUM"), rs.getString("EMAIL"), rs.getString("PAYMENT_METHOD"));
                Customers.add(customer);
            }
            
            
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
        return Customers;
    }
    
}
