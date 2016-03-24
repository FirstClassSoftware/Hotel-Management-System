/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.sql.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jessicaluu
 */
public class InventoryModel extends AbstractTableModel {
    
    private String host;
    private String username;
    private String password;
    private Connection con;
    private Statement stmt;
    private String SQL;
    private ResultSet rs;
    
    private List<Item> Inventory;
    
    private final String[] columnNames = new String[] {"Item Name", "Current Amount",
        "Maximum Amount", "Item Cost", "Item Status"};
    
    public InventoryModel() {
        
        try {
            
            host = "jdbc:sqlite:hotelData.db";
            username = "student";
            password = "password";
            
            con = DriverManager.getConnection(host, username, password);
            stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            
            SQL = "CREATE TABLE IF NOT EXISTS INVENTORY"
                    + "(ID INT PRIMARY KEY      NOT NULL,"
                    + "ITEM_NAME VARCHAR(255),"
                    + "CURRENT_AMOUNT VARCHAR(255),"
                    + "MAXIMUM_AMOUNT VARCHAR(255),"
                    + "ITEM_COST VARCHAR(255),"
                    + "ITEM_STATUS VARCHAR(255)";
            stmt.executeUpdate(SQL);
            
            SQL = "select * from INVENTORY";
            rs = stmt.executeQuery(SQL);
            
            
            
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
    
    
    
    
    
    @Override
    public int getRowCount() {
        getInventory();
        return Inventory.size();
    }
    
    @Override
    public int getColumnCount() {
        getInventory();
        return 5;
        //return Inventory.get(0).getSize();
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        getInventory();
        return Inventory.get(row).get(column);
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        getInventory();
        Inventory.get(row).setValue(col, value);
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
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return rows;
    }
    
    public void addNewInventory(String itemName, int currentAmount, int maxAmount,
            double itemCost, double itemStatus) {
        int oldID;
        int newID = 0;
        try {
            SQL = "select * from INVENTORY";
            rs = stmt.executeQuery(SQL);
            
            if (!rs.isBeforeFirst()) {
                newID = 1;
            } else {
                while (rs.next()) {
                    oldID = rs.getInt("ID");
                    newID = oldID + 1;
                }
            }
            
            stmt.executeUpdate("INSERT INTO INVENTORY(ID, ITEM_NAME, CURRENT_AMOUNT,"
                    + "MAXIMUM_AMOUNT, ITEM_COST, ITEM_STATUS)"
                    + "VALUES ( " + newID + ", '" + itemName + "', '" + currentAmount
                    + "', '" + maxAmount + "', '" + itemCost + "', '" + itemStatus
                    + "')");
            
            System.out.println("Successfully added to database");
            
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        
    }
    
    public ResultSet getResultSet() {
        try {
            SQL = "select * from INVENTORY";
            rs = stmt.executeQuery(SQL);
            return rs;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return rs;
    }
    
    public List<Item> getInventory() {
        Inventory = new ArrayList<Item>();
        try {
            ResultSet result = this.getResultSet();
            
            while(result.next()) {
                Item item = new Item(rs.getInt("ID"), rs.getString("ITEM_NAME"),
                rs.getInt("CURRENT_AMOUNT"), rs.getInt("MAXIMUM_AMOUNT"),
                rs.getDouble("ITEM_COST"), rs.getDouble("ITEM_STATUS"));
                
                Inventory.add(item);
            }
        } catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
        return Inventory;
    }

}
