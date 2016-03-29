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
            //System.exit(0);
            AddNewCustView addPanel = view.getNewCustView();
            
            String firstName = addPanel.getTxtFirstName().getText();
            String lastName = addPanel.getTxtLastName().getText();
            String numOfOccupants = addPanel.getTxtNumOfOccupants().getText();
            String occupationDate = addPanel.getTxtOccupationDate().getText();
            String address = addPanel.getTxtAddress().getText();
            String tab = addPanel.getTxtTab().getText();
            String lastRoomNum = addPanel.getTxtLastRoomNum().getText();
            String phoneNum = addPanel.getTxtPhoneNum().getText();
            String email = addPanel.getTxtEmail().getText();
            String paymentMethod = addPanel.getTxtPaymentMethod().getText();
            
            model.addNewCustomer(firstName, lastName, numOfOccupants, occupationDate, 
                    address, tab, lastRoomNum, phoneNum, email, paymentMethod);
            
            view.closeNewCustScreen();
            
        }
        
        if (e.getSource() == view.getBtnSearch()) {
            int column = view.getComboColumn();
            String querie = view.getFldSearchEntry();
            model.getCustomer(column, querie);
        }
        
    }
}