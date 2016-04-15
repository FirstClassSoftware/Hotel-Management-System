/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.RowFilter;
import java.util.regex.PatternSyntaxException;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jessicaluu
 */
public class InventoryController implements ActionListener {
    
    InventoryModel model;
    InventoryView view;
    
    public InventoryController(InventoryModel model, InventoryView view) {
        this.view = view;
        this.model = model;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        /*if (e.getSource() == view.getLowItemView().getBtnOK()) {
            view.closeView();
        }*/
        
        if (e.getSource() == view.getBtnHome()) {
            System.exit(0); // GO BACK TO HOME MAIN VIEW
        }
        
        if (e.getSource() == view.getBtnNewItem()) {
            view.showNewItemView();
        }
        
        if (e.getSource() == view.getNewItemView().getBtnOK()) {
            AddNewInventory pnlAddItem = view.getNewItemView();
            
            String itemName = pnlAddItem.getTxtItemName().getText();
            String txtCurrent = pnlAddItem.getTxtCurrentAmt().getText();
            int currentAmt = Integer.parseInt(txtCurrent);
            String txtMax = pnlAddItem.getTxtMaxAmt().getText();
            int maxAmt = Integer.parseInt(txtMax);
            String txtCost = pnlAddItem.getTxtItemCost().getText();
            double itemCost = Double.parseDouble(txtCost);
            
            model.addNewInventory(itemName, currentAmt, maxAmt, itemCost);
            // METHOD TO RETRIEVE DATABASE CHANGES TO BE SENT TO VIEW
            view.closeNewItemView();
        }
        
        if (e.getSource() == view.getBtnDeleteItem()) {
            int row = view.getSelectedRow();
            int column = 0;
            if (row >= 0) {
                int id = view.getValueAtCell(row, column);
                model.deleteRow(id);
            }
        }
        
        if (e.getSource() == view.getBtnSearch()) {
            int column = view.getCmbSearchColumn();
            String txtSearch = view.getTxtSearch();
            
            try {
                TableRowSorter sorter = view.getSorter();
                sorter.setRowFilter(RowFilter.regexFilter(txtSearch, column));
                view.setSorter(sorter);
            } catch (PatternSyntaxException pse) {
                System.err.println("Bad regex pattern");
            }
        }
    }
    
}
