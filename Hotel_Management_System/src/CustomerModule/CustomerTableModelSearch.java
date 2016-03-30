/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerModule;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Whelan
 */
public class CustomerTableModelSearch extends AbstractTableModel {
    
    private List<Customer> Customers;
    
    private final String[] columnNames = new String[] {"First Name", "Last Name", 
        "Number of Occupants", "Occupation Date", "Address", "Customer Tab", 
        "Previous Room Number", "Phone Number", "Email", "Payment Method"};
    
    public CustomerTableModelSearch(List<Customer> customers) {
        Customers = customers;
    }
    
    @Override
    public int getRowCount() {
        //getCustomers();
        return Customers.size();
    }
    
    @Override
    public int getColumnCount() {
        //getCustomers();
        int columns = 10;
        return columns;
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        //getCustomers();
        return Customers.get(row).get(column);
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        //getCustomers();
        Customers.get(row).setValue(col, value);
    }
    
}
