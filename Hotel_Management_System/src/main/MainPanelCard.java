/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import ReservationModule.ReservationModel;
import ReservationModule.ReservationControl;
import ReservationModule.ReservationView;
import CustomerModule.CustomerControl;
import CustomerModule.CustomerModel;
import CustomerModule.CustomerView;
import RoomModule.RoomsModel;
import javax.swing.JPanel;
import java.awt.CardLayout;

/**
 *
 * @author WhelanMyPC
 */
public class MainPanelCard extends JPanel {
    
    ReservationModel resModel;
    ReservationView resView;
    ReservationControl resControl;
    
    CustomerModel custModel;
    CustomerView custView;
    CustomerControl custControl;
    
    RoomsModel hotelModel;
    
    public MainPanelCard() {
        resModel = new ReservationModel();
        resView = new ReservationView(this, resModel);
        resControl = new ReservationControl(resModel, resView);
        resView.registerListener(resControl);
        
        custModel = new CustomerModel();
        custView = new CustomerView(this, custModel);
        custControl = new CustomerControl(custModel, custView);
        custView.registerListener(custControl);
        
        hotelModel = new RoomsModel();
        
        this.setLayout(new CardLayout());
        this.add(resView, "Reservation Screen");
        this.add(custView, "Customer Screen");
    }
    
}
