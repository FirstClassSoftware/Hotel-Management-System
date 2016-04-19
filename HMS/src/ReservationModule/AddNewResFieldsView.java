/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservationModule;

import CustomerModule.*;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * @author Whelan
 */
public class AddNewResFieldsView extends JPanel {
    //CustomerView parentCustView;
    
    private JLabel lblFloorNumber;
    private JLabel lblRoomNumber;
    private JLabel lblStartDate;
    private JLabel lblEndDate;
    private JLabel lblCustomerFirstName;
    private JLabel lblCustomerLastName;
    private JLabel lblRoomType;
    private JLabel lblCost;
    
    private JTextField txtFloorNumber;
    private JTextField txtRoomNumber;
    private JTextField txtStartDate;
    private JTextField txtEndDate;
    private JTextField txtCustomerFirstName;
    private JTextField txtCustomerLastName;
    private JTextField txtRoomType;
    private JTextField txtCost;

    
    private JButton btnSubmit;
    
    
    public AddNewResFieldsView() {
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.ipadx = 10;
        c.anchor = c.LINE_END;
        Insets topSpaceInset = new Insets(10, 0, 0 ,0);
        c.insets = topSpaceInset;
        
        
        
        
        
        
        
        lblFloorNumber = new JLabel("Floor Number");
        c.gridx = 0;
        c.gridy = 0;
        this.add(lblFloorNumber, c);
        
        lblRoomNumber = new JLabel("Room Number");
        c.gridx = 0;
        c.gridy = 1;
        this.add(lblRoomNumber, c);
        
        lblStartDate = new JLabel("Start Date");
        c.gridx = 0;
        c.gridy = 2;
        this.add(lblStartDate, c);
        
        lblEndDate = new JLabel("End Date");
        c.gridx = 0;
        c.gridy = 3;
        this.add(lblEndDate, c);
        
        lblCustomerFirstName = new JLabel("Customer First Name");
        c.gridx = 0;
        c.gridy = 4;
        this.add(lblCustomerFirstName, c);
        
        lblCustomerLastName = new JLabel("Customer Last Name");
        c.gridx = 0;
        c.gridy = 5;
        this.add(lblCustomerLastName, c);
        
        lblRoomType = new JLabel("Room Type");
        c.gridx = 0;
        c.gridy = 6;
        this.add(lblRoomType, c);
        
        lblCost = new JLabel("Cost");
        c.gridx = 0;
        c.gridy = 7;
        this.add(lblCost, c);
        
        
        
        
        
        
        
        int txtSize = 20;
        txtFloorNumber = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 0;
        this.add(txtFloorNumber, c);
        
        txtRoomNumber = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 1;
        this.add(txtRoomNumber, c);
        
        txtStartDate = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 2;
        this.add(txtStartDate, c);
        
        txtEndDate = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 3;
        this.add(txtEndDate, c);
        
        txtCustomerFirstName = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 4;
        this.add(txtCustomerFirstName, c);
        
        txtCustomerLastName = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 5;
        this.add(txtCustomerLastName, c);
        
        txtRoomType = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 6;
        this.add(txtRoomType, c);
        
        txtCost = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 7;
        this.add(txtCost, c);
        
        /*
        txtCustomerFirstName.setText(custFirstName);
        txtCustomerLastName.setText(custLastName);
        txtStartDate.setText(startDate);
        */
        
        
        
        
        
        
        btnSubmit = new JButton();
        btnSubmit.setText("Submit");
        c.gridx = 0;
        c.gridy = 10;
        c.gridwidth = 2;
        c.anchor = c.CENTER;
        this.add(btnSubmit, c);
    }

   
    
    public void resetFields() {
        
        getTxtFloorNumber().setText("");
        getTxtRoomNumber().setText("");
        getTxtStartDate().setText("");
        getTxtEndDate().setText("");
        getTxtCustomerFirstName().setText("");
        getTxtCustomerLastName().setText("");
        getTxtRoomType().setText("");
        getTxtCost().setText("");
        
    }

    public JLabel getLblFloorNumber() {
        return lblFloorNumber;
    }

    public void setLblFloorNumber(JLabel lblFloorNumber) {
        this.lblFloorNumber = lblFloorNumber;
    }

    public JLabel getLblRoomNumber() {
        return lblRoomNumber;
    }

    public void setLblRoomNumber(JLabel lblRoomNumber) {
        this.lblRoomNumber = lblRoomNumber;
    }

    public JLabel getLblStartDate() {
        return lblStartDate;
    }

    public void setLblStartDate(JLabel lblStartDate) {
        this.lblStartDate = lblStartDate;
    }

    public JLabel getLblEndDate() {
        return lblEndDate;
    }

    public void setLblEndDate(JLabel lblEndDate) {
        this.lblEndDate = lblEndDate;
    }

    public JLabel getLblCustomerFirstName() {
        return lblCustomerFirstName;
    }

    public void setLblCustomerFirstName(JLabel lblCustomerFirstName) {
        this.lblCustomerFirstName = lblCustomerFirstName;
    }

    public JLabel getLblCustomerLastName() {
        return lblCustomerLastName;
    }

    public void setLblCustomerLastName(JLabel lblCustomerLastName) {
        this.lblCustomerLastName = lblCustomerLastName;
    }

    public JLabel getLblRoomType() {
        return lblRoomType;
    }

    public void setLblRoomType(JLabel lblRoomType) {
        this.lblRoomType = lblRoomType;
    }

    public JLabel getLblCost() {
        return lblCost;
    }

    public void setLblCost(JLabel lblCost) {
        this.lblCost = lblCost;
    }

    public JTextField getTxtFloorNumber() {
        return txtFloorNumber;
    }

    public void setTxtFloorNumber(JTextField txtFloorNumber) {
        this.txtFloorNumber = txtFloorNumber;
    }

    public JTextField getTxtRoomNumber() {
        return txtRoomNumber;
    }

    public void setTxtRoomNumber(JTextField txtRoomNumber) {
        this.txtRoomNumber = txtRoomNumber;
    }

    public JTextField getTxtStartDate() {
        return txtStartDate;
    }

    public void setTxtStartDate(String txtStartDate) {
        this.txtStartDate.setText(txtStartDate);
    }

    public JTextField getTxtEndDate() {
        return txtEndDate;
    }

    public void setTxtEndDate(JTextField txtEndDate) {
        this.txtEndDate = txtEndDate;
    }

    public JTextField getTxtCustomerFirstName() {
        return txtCustomerFirstName;
    }

    public void setTxtCustomerFirstName(String txtCustomerFirstName) {
        this.txtCustomerFirstName.setText(txtCustomerFirstName);
        System.out.println("text set");
    }

    public JTextField getTxtCustomerLastName() {
        return txtCustomerLastName;
    }

    public void setTxtCustomerLastName(String txtCustomerLastName) {
        this.txtCustomerLastName.setText(txtCustomerLastName);
    }

    public JTextField getTxtRoomType() {
        return txtRoomType;
    }

    public void setTxtRoomType(JTextField txtRoomType) {
        this.txtRoomType = txtRoomType;
    }

    public JTextField getTxtCost() {
        return txtCost;
    }

    public void setTxtCost(JTextField txtCost) {
        this.txtCost = txtCost;
    }

    public JButton getBtnSubmit() {
        return btnSubmit;
    }

    public void setBtnSubmit(JButton btnSubmit) {
        this.btnSubmit = btnSubmit;
    }
    
}
