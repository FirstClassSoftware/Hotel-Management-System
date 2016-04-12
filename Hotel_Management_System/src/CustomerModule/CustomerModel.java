/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    
    private final String[] columnNames = new String[] {"ID", "First Name", "Last Name", 
        "Number of Occupants", "Occupation Date", "Address", "Customer Tab", 
        "Previous Room Number", "Phone Number", "Email", "Payment Method"};
    
    private final String tableNameSQL = "CUSTOMERS";
    
    private final String[] columnNamesSQL = new String[] {"ID", "FIRST_NAME", "LAST_NAME", 
        "NUMBER_OF_OCCUPANTS", "OCCUPATION_DATE", "ADDRESS", "CUSTOMER_TAB", 
        "PREVIOUS_ROOM_NUMBER", "PHONE_NUMBER", "EMAIL", "PAYMENT_METHOD"};
    
    int colNameArrayValue;
    
    boolean isEditable;
    
    public CustomerModel() {
         
        try {
            
            host = "jdbc:sqlite:hotelData.db";
            username = "";
            password = "";
        
            con = DriverManager.getConnection(host, username, password);
            stmt = con.createStatement( ResultSet.TYPE_FORWARD_ONLY, 
                    ResultSet.CONCUR_READ_ONLY);
            
            colNameArrayValue = 0;
            SQL = "CREATE TABLE IF NOT EXISTS " + tableNameSQL 
                    + "(" + columnNamesSQL[colNameArrayValue++] + " INT PRIMARY KEY     NOT NULL,"
                    + columnNamesSQL[colNameArrayValue++] + " VARCHAR(255),"
                    + columnNamesSQL[colNameArrayValue++] + " VARCHAR(255),"
                    + columnNamesSQL[colNameArrayValue++] + " VARCHAR(255),"
                    + columnNamesSQL[colNameArrayValue++] + " VARCHAR(255),"
                    + columnNamesSQL[colNameArrayValue++] + " VARCHAR(255),"
                    + columnNamesSQL[colNameArrayValue++] + " VARCHAR(255),"
                    + columnNamesSQL[colNameArrayValue++] + " VARCHAR(255),"
                    + columnNamesSQL[colNameArrayValue++] + " VARCHAR(255),"
                    + columnNamesSQL[colNameArrayValue++] + " VARCHAR(255),"
                    + columnNamesSQL[colNameArrayValue++] + " VARCHAR(255))";
            stmt.executeUpdate(SQL);
            
            SQL = "select * from " + tableNameSQL;
            rs = stmt.executeQuery(SQL);
            
            //System.out.println("table created");
            
        }
        
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
        isEditable = true;
        
    } 
    
    
    
    
    
    
    
    
    
    @Override
    public int getRowCount() {
        getCustomers();
        return Customers.size();
    }
    
    @Override
    public int getColumnCount() {
        getCustomers();
        int columns = 11;
        return columns;
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
        //Customers.get(row).setValue(col, value);
        setCustomerValue(value, row, col);
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return isEditable;
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void addNewCustomer(String firstName, String lastName, String numOfOccupants, 
            String occupationDate, String address, String tab, String lastRoomNum, 
            String phoneNum, String email, String paymentMethod) {
        
        int oldID;
        int newID = 0;
        try {
            SQL = "select * from " + tableNameSQL;
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
            
            colNameArrayValue = 0;
            stmt.executeUpdate("INSERT INTO " + tableNameSQL +" (" 
                    + columnNamesSQL[colNameArrayValue++] + ", "
                    + columnNamesSQL[colNameArrayValue++] + ", "
                    + columnNamesSQL[colNameArrayValue++] + ", "
                    + columnNamesSQL[colNameArrayValue++] + ", "
                    + columnNamesSQL[colNameArrayValue++] + ", "
                    + columnNamesSQL[colNameArrayValue++] + ", "
                    + columnNamesSQL[colNameArrayValue++] + ", "
                    + columnNamesSQL[colNameArrayValue++] + ", "
                    + columnNamesSQL[colNameArrayValue++] + ", "
                    + columnNamesSQL[colNameArrayValue++] + ", "
                    + columnNamesSQL[colNameArrayValue++] + ") "
                    + "VALUES ( " 
                    + newID + ", '" + firstName + "', '" + lastName + "', '"
                    + numOfOccupants + "', '" + occupationDate + "', '" + address + "', '" 
                    + tab + "', '" + lastRoomNum + "', '" + phoneNum + "', '"
                    + email + "', '" + paymentMethod + "')");
            
            //System.out.println("Successfully added to database");
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
        this.fireTableDataChanged();
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<Customer> getCustomers() {
        Customers = new ArrayList<>();
        try {
            ResultSet result = this.getResultSet();
            
            colNameArrayValue = 0;
            while(result.next()) {
                //System.out.println(rs.getInt(columnNamesSQL[colNameArrayValue++]));
                Customer customer = new Customer(rs.getInt("ID"), rs.getString("FIRST_NAME"), 
                        rs.getString("LAST_NAME"), rs.getString("NUMBER_OF_OCCUPANTS"), 
                        rs.getString("OCCUPATION_DATE"), rs.getString("ADDRESS"), 
                        rs.getString("CUSTOMER_TAB"), rs.getString("PREVIOUS_ROOM_NUMBER"), 
                        rs.getString("PHONE_NUMBER"), rs.getString("EMAIL"), rs.getString("PAYMENT_METHOD"));
                
                //System.out.println(customer.getID());
                //System.out.println(Customers.isEmpty());
                Customers.add(customer);
            }
            
            
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
        return Customers;
    }
    
    public ResultSet getResultSet() {
        try {
            SQL = "select * from " + tableNameSQL;
            rs = stmt.executeQuery(SQL);
            return rs;
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        return rs;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public void setCustomerValue(Object value, int row, int column) {
        
        try {
            //UPDATE users SET role=99 WHERE name='Fred'
            if(column != 0) {
            int id = Customers.get(row).getID();
            stmt.executeUpdate("UPDATE " + tableNameSQL + " SET " + columnNamesSQL[column] 
                    + " = '" + value + "' WHERE ID = " + id);
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
            stmt.executeUpdate("delete from " + tableNameSQL + " WHERE ID = " + id);
            this.fireTableDataChanged();
            
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
    }
    
    public void deleteAllFromTable() {
        
        try {
            stmt.executeUpdate("delete from " + tableNameSQL);
            
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
    }
    
    public void setIsEditable(boolean isEdit) {
        isEditable = isEdit;
    }
    
    public Date isCorrectDateFormat(String input) {
        Date date = null;
        
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        try {
            date = format.parse(input);
            System.out.println(date);
            return date;
            
            //return true;
        }
        catch (java.text.ParseException err) {
            System.out.println(err.getMessage());
        }
        
        return date;
        
    }
    
    public boolean isDateNull(Date input) {
        if(input == null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    
    
}
