/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDatabase;

import ResCust.ReservationModel;
/**
 *
 * @author Whelan
 */
public class tstDatabase {
    
    ReservationModel m;
    
    public tstDatabase() {
        
        //m = new ReservationModel();
        
    }
    
    public static void main(String[] args) {
        
        ReservationModel model = new ReservationModel();
        model.addNewReservation("1", "01", "01/01/1927", "02/04,1984", "John", "Jackson", "King", 10);
        String out = model.printReservationsIDSort();
        System.out.println(out);
        
        
    }
    
}
