/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservationModule;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import CustomerModule.*;

/**
 *
 * @author WhelanMyPC
 */
public class ReservationControl implements ActionListener {
    
    ReservationView view;
    ReservationModel model;
    
    public ReservationControl(ReservationModel m, ReservationView v) {
        model = m;
        view = v;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == view.getBtnHome()) {
            System.exit(0);
        }
        
        if (e.getSource() == view.getBtnGoToCust()) {
            view.goToCust();
        }
        
        if (e.getSource() == view.getBtnNewRes()) {
            view.showNewResChoiceView();
        }
             
        if (e.getSource() == view.getBtnDeleteRow()) {
            int row = view.getSelectedRow();
            int column = 0;
            if (row >= 0) {
                int id = view.getValueAtCell(row, column);
                model.deleteRowFromTable(id);
                view.refreshTableModel();
            }
        }
        
        if (e.getSource() == view.getChoiceView().getBtnNewCust()) {
            view.showNewCustScreen();
        }
        
        /*
        
        if (e.getSource() == view.getChoiceView().getBtnSubmit()) {
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
            String querie = view.getFldSearchEntry().getText();
            
            CustomerTableModelSearch newModel = new CustomerTableModelSearch(model.getCustSearch(column, querie));
            view.setTableModel(newModel);
        }
                */
    }
}
