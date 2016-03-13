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
    
    ReservationModel m;
    
    public tstDatabase() {
        
        //m = new ReservationModel();
        
    }
    
    public static void main(String[] args) {
        
        
        
        ReservationModel model = new ReservationModel();
        model.addNewReservation("1", "01", "01/01/1927", "02/04,1984", "John", "Jackson", "King", 10);
        String out = model.printReservationsIDSort();
        //System.out.println(out);
        
        List<Reservation> Reservations = model.getReservations();
        
        for (int i=0; i < Reservations.size() ; i++) {
            Reservation reserve = Reservations.get(i);
            
            System.out.println(reserve.getcustNameFirst());
        }
        
    }
    
}
