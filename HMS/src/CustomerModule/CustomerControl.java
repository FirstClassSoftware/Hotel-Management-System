/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerModule;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.RowFilter;
import java.util.regex.PatternSyntaxException;
import javax.swing.table.TableRowSorter;

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
        
        if (e.getSource() == view.getBtnRefreshTable()) {
            //view.refreshTableModel();
        }
        
        if (e.getSource() == view.getBtnDeleteRow()) {
            int row = view.getSelectedRow();
            int column = 0;
            if (row >= 0) {
                int id = view.getValueAtCell(row, column);
                model.deleteRowFromTable(id);
                //view.refreshTableModel();
            }
        }
        
        if (e.getSource() == view.getNewCustView().getBtnSubmit()) {
            AddNewCustPanel addPanel = view.getNewCustView();
            String[] inputs = addPanel.getInputs();
            
            if(model.isCorrectDateFormat(inputs[3]) == false) {
                view.showNewCustError("Occupation Date");
            }
            else {
                model.addNewCustomer(inputs[0], inputs[1], inputs[2], inputs[3], 
                    inputs[4], inputs[5], inputs[6], inputs[7], inputs[8], inputs[9]);
                view.closeNewCustScreen();
            }
            
            
        }
        
        if (e.getSource() == view.getErrorPanel().getBtnExit()) {
            view.closeErrorFrame();
        }
        
        if (e.getSource() == view.getBtnSearch()) {
            int column = view.getComboColumn();
            String querie = view.getFldSearchEntry();
            try {
                TableRowSorter sorter = view.getSorter();
                sorter.setRowFilter(RowFilter.regexFilter(querie, column));
                view.setSorter(sorter);
            } catch (PatternSyntaxException pse) {
                System.out.println(pse.getMessage());
            }
        }
       // This is actionperfomed 
    }
    
    
    
    // This is end of code
}