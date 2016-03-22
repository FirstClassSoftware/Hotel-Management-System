/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import ResCust.*;
import javax.swing.JPanel;
import java.awt.CardLayout;

/**
 *
 * @author WhelanMyPC
 */
public class MainPanelCard extends JPanel {
    
    ReservationView r;
    CustomerView c;
    
    public MainPanelCard() {
        r = new ReservationView(this);
        c = new CustomerView(this);
        
        this.setLayout(new CardLayout());
        this.add(r, "Reservation Screen");
        this.add(c, "Customer Screen");
    }
    
}
