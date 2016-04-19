/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * @author jessicaluu
 */
public class AddNewInventory extends JPanel {
    
    private JLabel lblItemName;
    private JLabel lblCurrentAmt;
    private JLabel lblMaxAmt;
    private JLabel lblItemCost;
    
    private JTextField txtItemName;
    private JTextField txtCurrentAmt;
    private JTextField txtMaxAmt;
    private JTextField txtItemCost;
    
    private JButton btnOK;
    
    public AddNewInventory() {
    
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.ipadx = 10;
        c.anchor = c.LINE_END;
        Insets topSpaceInset = new Insets (5, 0, 0, 0);
        c.insets = topSpaceInset;
        
        // LABELS - ITEMNAME, CURRENTAMT, MAXAMT, ITEMCOST
        lblItemName = new JLabel("Item Name:");
        c.gridx = 0;
        c.gridy = 0;
        this.add(lblItemName, c);
        
        lblCurrentAmt = new JLabel("Current Amount:");
        c.gridx = 0;
        c.gridy = 1;
        this.add(lblCurrentAmt, c);
        
        lblMaxAmt = new JLabel("Maximum Amount:");
        c.gridx = 0;
        c.gridy = 2;
        this.add(lblMaxAmt, c);
        
        lblItemCost = new JLabel("Item Cost:");
        c.gridx = 0;
        c.gridy = 3;
        this.add(lblItemCost, c);
        
        // TEXT FIELDS - ITEMNAME, CURRENTAMT, MAXAMT, ITEMCOST
        int txtSize = 20;
        txtItemName = new JTextField(txtSize);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        this.add(txtItemName, c);
        
        txtCurrentAmt = new JTextField(txtSize);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        this.add(txtCurrentAmt, c);
        
        txtMaxAmt = new JTextField(txtSize);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        this.add(txtMaxAmt, c);
        
        txtItemCost = new JTextField(txtSize);
        c.fill = GridBagConstraints.HORIZONTAL;
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
