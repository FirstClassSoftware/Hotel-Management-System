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
    
    ReservationView resView;
    ReservationModel resModel;
    
    CustomerModel custModel;
    
    public ReservationControl(ReservationModel resModel, ReservationView resView, CustomerModel custModel) {
        this.resModel = resModel;
        this.resView = resView;
        this.custModel = custModel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == resView.getBtnHome()) {
            System.exit(0);
        }
        
        if (e.getSource() == resView.getBtnGoToCust()) {
            resView.goToCust();
        }
        
        if (e.getSource() == resView.getBtnNewRes()) {
            resView.showNewResChoiceView();
        }
             
        if (e.getSource() == resView.getBtnDeleteRow()) {
            int row = resView.getSelectedRow();
            int column = 0;
            if (row >= 0) {
                int id = resView.getValueAtCell(row, column);
                resModel.deleteRowFromTable(id);
                resView.refreshTableModel();
            }
        }
        
        if (e.getSource() == resView.getChoiceView().getBtnNewCust()) {
            resView.showNewCustScreen();
        }
        
        if (e.getSource() == resView.getNewCustView().getBtnSubmit()) {
            AddNewCustView addPanel = resView.getNewCustView();
            
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
            
            custModel.addNewCustomer(firstName, lastName, numOfOccupants, occupationDate, 
                    address, tab, lastRoomNum, phoneNum, email, paymentMethod);
            
            resView.closeNewCustScreen();
            resView.showNewResScreen();
        }
        
        
        
        if (e.getSource() == resView.getNewResView().getBtnSubmit()) {
            AddNewResView addPanel = resView.getNewResView();
            
            String floorNumber = addPanel.getTxtFloorNumber().getText();
            String roomNumber = addPanel.getTxtRoomNumber().getText();
            String startDate = addPanel.getTxtStartDate().getText();
            String endDate = addPanel.getTxtEndDate().getText();
            String custFirstName = addPanel.getTxtCustomerFirstName().getText();
            String custLastName = addPanel.getTxtCustomerLastName().getText();
            String roomType = addPanel.getTxtRoomType().getText();
            String cost = addPanel.getTxtCost().getText();
                Double costDouble;
                if (cost.isEmpty()) {
                    costDouble = 0.0;
                }
                else {
                    costDouble = Double.parseDouble(cost);
                }
            
            resModel.addNewReservation(floorNumber, roomNumber, startDate, endDate, 
                    custFirstName, custLastName, roomType, costDouble);
            
            System.out.println("Succesfully added Reservation");
            resView.closeNewResScreen();
            
        }
        
        /*
        if (e.getSource() == resView.getBtnSearch()) {
            int column = resView.getComboColumn();
            String querie = resView.getFldSearchEntry().getText();
            
            CustomerTableModelSearch newModel = new CustomerTableModelSearch(model.getCustSearch(column, querie));
            view.setTableModel(newModel);
        }
                */
                
    }
}
