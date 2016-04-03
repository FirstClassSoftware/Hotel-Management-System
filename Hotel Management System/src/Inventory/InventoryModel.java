/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
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
    
    private final String[] columnNamesSQL = new String[] {"ITEM_NAMAE",
        "CURRENT_AMOUNT", "MAXIMUM_AMOUNT", "ITEM_COST", "ITEM_STATUS"};
    
    public InventoryModel() {
        
        try {
            
            host = "jdbc:sqlite:hotelData.db";
            username = "student";
            password = "password";
            
            con = DriverManager.getConnection(host, username, password);
            // System.out.println("Opened database successfully");
            
            stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            
            SQL = "CREATE TABLE IF NOT EXISTS INVENTORY"
                    + "(ID INT PRIMARY KEY      NOT NULL,"
                    + "ITEM_NAME        VARCHAR(255),"
                    + "CURRENT_AMOUNT   INT,"
                    + "MAXIMUM_AMOUNT   INT,"
                    + "ITEM_COST        DOUBLE,"
                    + "ITEM_STATUS      DOUBLE";
            stmt.executeUpdate(SQL);
            
            SQL = "select * from INVENTORY";
            rs = stmt.executeQuery(SQL);
            
        
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        
        // System.out.println("Table created successfully");
    }
    
    
    @Override
    public int getRowCount() {
        getInventory();
        return Inventory.size();
    }
    
    @Override
    public int getColumnCount() {
        getInventory();
        int columns = 5;
        return columns;
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
    public boolean isCellEditable(int row, int column) {
        return true;
    }
    
    @Override
    public void setValueAt(Object value, int row, int column) {
        getInventory();
        setItemValue(value, row, column);
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
            double itemCost) {
        
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
            
            stmt.executeUpdate("INSERT INTO INVENTORY (ID, ITEM_NAME, CURRENT_AMOUNT,"
                    + "MAXIMUM_AMOUNT, ITEM_COST) "
                    + "VALUES (" + newID + ", '" + itemName + "', " + currentAmount
                    + ", " + maxAmount + ", " + itemCost + ")");
            
            // System.out.println("Successfully added to database");
            
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        
        this.fireTableDataChanged();
        
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
    
    public List<Item> getItemSearch(int column, String query) {
        getInventory();
        List<Item> itemSearch = new ArrayList<>();
        for (int i  = 0; i < Inventory.size(); i++) {
            if(Inventory.get(i).get(column).equals(query)) {
                //System.out.println("Retrieving item...");
                itemSearch.add(Inventory.get(i));
            }
        }
        return itemSearch;
    }
    
    public void setItemValue(Object value, int row, int column) {
        try {
            // UPDATE users SET role = 99 WHERE name = 'Fred'
            row++;
            stmt.executeUpdate("UPDATE INVENTORY SET " + columnNamesSQL[column] + " = '" + value + "' WHERE ID = " + row);
            // System.out.println("Successfully udpated...");
        } catch(SQLException err) {
            System.out.println(err.getMessage());
        }
    }
    
    public void deleteRow(int row) {
        try {
            row++;
            
            stmt.executeUpdate("DELETE FROM CUSTOMERS WHERE ID = " + row);
        } catch(SQLException err) {
            System.out.println(err.getMessage());
        }
    }
    

}
