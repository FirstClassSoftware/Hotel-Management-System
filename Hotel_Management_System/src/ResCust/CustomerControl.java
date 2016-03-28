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
 * @author WhelanMyPC
 */
public class CustomerControl implements ActionListener {
    
    CustomerView view;
    CustomerModel model;
    
    public CustomerControl(CustomerModel m, CustomerView v) {
        model = m;
        view = v;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == view.getBtnHome()) {
            System.exit(0);
        }
        
        if (e.getSource() == view.getBtnGoToRes()) {
            view.goToRes();
        }
        
        if (e.getSource() == view.getBtnNewCust()) {
            view.showNewCustScreen();
        }
        
        if (e.getSource() == view.getNewCustView().getBtnSubmit()) {
            System.exit(0);
        }
        
    }
}