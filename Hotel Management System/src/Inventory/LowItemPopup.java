/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import javax.swing.*;

/**
 *
 * @author jessicaluu
 */
public class LowItemPopup extends JOptionPane {
    
    InventoryView parentInventoryView;
    
    JButton btnOK;
    String itemName;
    
    public LowItemPopup(InventoryView parentInventoryView) {
        this.parentInventoryView = parentInventoryView;
        String message = "Item is running low. Status is 20% or below.";
        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.WARNING_MESSAGE);
    }
    
    // GETTERS
    public JButton getBtnOK() {
        return btnOK;
    }
    
    // SETTERS
    public void setBtnOK() {
        this.btnOK = btnOK;
    }
    
}
