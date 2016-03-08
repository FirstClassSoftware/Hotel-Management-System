/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResCust;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Whelan
 */
public class ReservationControl implements ActionListener{
    
    private final ReservationView view;
    private final ReservationModel model;
    
    public ReservationControl(ReservationView v, ReservationModel m) {
        this.view = v;
        this.model = m;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
