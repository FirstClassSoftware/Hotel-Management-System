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
        
        //m = new ReservationModel();
        
    }
    
    public static void main(String[] args) {
        
        
        
        CustomerModel c = new CustomerModel();
        c.addNewCustomer("John", "Jackson", "3", "02/04,1984", "800 Peachtree St", "0", "206", "911", "cwrok@gmail.com", "Credit Card");
        //String out = model.printReservationsIDSort();
        //System.out.println(out);
        
        List<Customer> Customers = c.getCustomers();
        
        for (int i=0; i < Customers.size() ; i++) {
            Customer cust = Customers.get(i);
            
            System.out.println(cust.getID());
        }
        
    }
    
}
