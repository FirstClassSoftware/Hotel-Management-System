/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDatabase;

import ResCust.ReservationModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import ResCust.*;
/**
 *
 * @author Whelan
 */
public class tstDatabase {
    
    public tstDatabase() {
        
    }
    
    public static void main(String[] args) {
        
        tstDatabase t = new tstDatabase();
        
        CustomerModel c = new CustomerModel();
        //c.addNewCustomer("John", "Jackson", "3", "02/04/1984", "800 Peachtree St", 
               // "0", "206", "911", "cwork@gmail.com", "Credit Card");
        
        List<Customer> Customers = c.getCustomers();
        //t.printCustomers(Customers);
        
        t.printCustomer(c.getCustomer(0, "John"));
        
        c.deleteAllFromTable();
        
    }
    
    public void printCustomers(List<Customer> Customers ) {
        for (int i=0; i < Customers.size() ; i++) {
            Customer cust = Customers.get(i);
            printCustomer(cust);
            
            System.out.println("");
        }
    }
    
    public void printCustomer(Customer customer) {
        for(int j = 0; j < 10; j++) {
            System.out.println(customer.get(j));  
        }
    }
    
}
