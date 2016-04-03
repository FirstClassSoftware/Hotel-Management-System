/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author jessicaluu
 */
public class AddNewInventory extends JPanel {
    
    InventoryView parentInventoryView;
    
    private JLabel lblItemName;
    private JLabel lblCurrentAmt;
    private JLabel lblMaxAmt;
    private JLabel lblItemCost;
    
    private JTextField txtItemName;
    private JTextField txtCurrentAmt;
    private JTextField txtMaxAmt;
    private JTextField txtItemCost;
    
    private JButton btnOK;
    
    public AddNewInventory(InventoryView parentInventoryView) {
        this.parentInventoryView = parentInventoryView;
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.ipadx = 10;
        c.anchor = c.LINE_END;
        Insets topSpaceInset = new Insets (10, 0, 0, 0);
        c.insets = topSpaceInset;
        
        // LABELS - ITEMNAME, CURRENTAMT, MAXAMT, ITEMCOST
        lblItemName = new JLabel("Item Name:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(lblItemName, c);
        
        lblCurrentAmt = new JLabel("Current Amount:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        this.add(lblCurrentAmt, c);
        
        lblMaxAmt = new JLabel("Maximum Amount:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        this.add(lblMaxAmt, c);
        
        lblItemCost = new JLabel("Item Cost:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        this.add(lblItemCost, c);
        
        // TEXT FIELDS - ITEMNAME, CURRENTAMT, MAXAMT, ITEMCOST
        int txtSize = 20;
        txtItemName = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 0;
        this.add(txtItemName, c);
        
        txtCurrentAmt = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 1;
        this.add(txtCurrentAmt, c);
        
        txtMaxAmt = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 2;
        this.add(txtMaxAmt, c);
        
        txtItemCost = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 3;
        this.add(txtItemCost, c);
        
        // BUTTONS - OK
        btnOK = new JButton();
        btnOK.setText("OK");
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.anchor = c.CENTER;
        this.add(btnOK, c);
        
    }
    // GETTERS
    public JLabel getLblItemName() {
        return lblItemName;
    }
    
    public JLabel getLblCurrentAmt() {
        return lblCurrentAmt;
    }
    
    public JLabel getLblMaxAmt() {
        return lblMaxAmt;
    }
    
    public JLabel getLblItemCost() {
        return lblItemCost;
    }
    
    public JTextField getTxtItemName() {
        return txtItemName;
    }
    
    public JTextField getTxtCurrentAmt() {
        return txtCurrentAmt;
    }
    
    public JTextField getTxtMaxAmt() {
        return txtMaxAmt;
    }
    
    public JTextField getTxtItemCost() {
        return txtItemCost;
    }
    
    public JButton getBtnOK() {
        return btnOK;
    }
    
    // SETTERS
    public void setLblItemName(JLabel lblItemName) {
        this.lblItemName = lblItemName;
    }
    
    public void setLblCurrentAmt(JLabel lblCurrentAmt) {
        this.lblCurrentAmt = lblCurrentAmt;
    }
    
    public void setLblMaxAmt(JLabel lblMaxAmt) {
        this.lblMaxAmt = lblMaxAmt;
    }
    
    public void setLblItemCost(JLabel lblItemCost) {
        this.lblItemCost = lblItemCost;
    }
    
    public void setTxtItemName(JTextField txtItemName) {
        this.txtItemName = txtItemName;
    }
    
    public void setTxtCurrentAmt(JTextField txtCurrentAmt) {
        this.txtCurrentAmt = txtCurrentAmt;
    }
    
    public void setTxtMaxAmt(JTextField txtMaxAmt) {
        this.txtMaxAmt = txtMaxAmt;
    }
    
    public void setItemCost(JTextField txtItemCost) {
        this.txtItemCost = txtItemCost;
    }
    
    public void setBtnOK(JButton btnOK) {
        this.btnOK = btnOK;
    }
    
    // INSTANCE METHODS
    public void resetFields() {
        txtItemName.setText("");
        txtCurrentAmt.setText("");
        txtMaxAmt.setText("");
        txtItemCost.setText("");
    }
    
}
