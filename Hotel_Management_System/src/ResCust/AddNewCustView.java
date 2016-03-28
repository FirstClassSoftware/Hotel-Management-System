/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResCust;

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
public class AddNewCustView extends JPanel {
    CustomerView parentCustView;
    
    JPanel pnlLabel;
    JPanel pnlTextField;
    JPanel pnlButton;
    
    JLabel lblFirstName;
    JLabel lblLastName;
    JLabel lblNumOfOccupants;
    JLabel lblOccupationDate;
    JLabel lblAddress;
    JLabel lblTab;
    JLabel lblLastRoomNum;
    JLabel lblPhoneNum;
    JLabel lblEmail;
    JLabel lblPaymentMethod;
    
    JTextField txtFirstName;
    JTextField txtLastName;
    JTextField txtNumOfOccupants;
    JTextField txtOccupationDate;
    JTextField txtAddress;
    JTextField txtTab;
    JTextField txtLastRoomNum;
    JTextField txtPhoneNum;
    JTextField txtEmail;
    JTextField txtPaymentMethod;
    
    JButton btnSubmit;
    
    
    public AddNewCustView(CustomerView parentCustView) {
        this.parentCustView = parentCustView;
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.ipadx = 10;
        c.anchor = c.LINE_END;
        Insets topSpaceInset = new Insets(10, 0, 0 ,0);
        c.insets = topSpaceInset;
        
        
        
        
        
        
        
        lblFirstName = new JLabel("First Name");
        c.gridx = 0;
        c.gridy = 0;
        this.add(lblFirstName, c);
        
        lblLastName = new JLabel("Last Name");
        c.gridx = 0;
        c.gridy = 1;
        this.add(lblLastName, c);
        
        lblNumOfOccupants = new JLabel("Number of Occupants");
        c.gridx = 0;
        c.gridy = 2;
        this.add(lblNumOfOccupants, c);
        
        lblOccupationDate = new JLabel("Occupation Date");
        c.gridx = 0;
        c.gridy = 3;
        this.add(lblOccupationDate, c);
        
        lblAddress = new JLabel("Address");
        c.gridx = 0;
        c.gridy = 4;
        this.add(lblAddress, c);
        
        lblTab = new JLabel("Tab");
        c.gridx = 0;
        c.gridy = 5;
        this.add(lblTab, c);
        
        lblLastRoomNum = new JLabel("Last Room Number");
        c.gridx = 0;
        c.gridy = 6;
        this.add(lblLastRoomNum, c);
        
        lblPhoneNum = new JLabel("Phone Number");
        c.gridx = 0;
        c.gridy = 7;
        this.add(lblPhoneNum, c);
        
        lblEmail = new JLabel("Email Address");
        c.gridx = 0;
        c.gridy = 8;
        this.add(lblEmail, c);
        
        lblPaymentMethod = new JLabel("Payment Method");
        c.gridx = 0;
        c.gridy = 9;
        this.add(lblPaymentMethod, c);
        
        
        
        
        
        
        
        int txtSize = 20;
        txtFirstName = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 0;
        this.add(txtFirstName, c);
        
        txtLastName = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 1;
        this.add(txtLastName, c);
        
        txtNumOfOccupants = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 2;
        this.add(txtNumOfOccupants, c);
        
        txtOccupationDate = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 3;
        this.add(txtOccupationDate, c);
        
        txtAddress = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 4;
        this.add(txtAddress, c);
        
        txtTab = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 5;
        this.add(txtTab, c);
        
        txtLastRoomNum = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 6;
        this.add(txtLastRoomNum, c);
        
        txtPhoneNum = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 7;
        this.add(txtPhoneNum, c);
        
        txtEmail = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 8;
        this.add(txtEmail, c);
        
        txtPaymentMethod = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 9;
        this.add(txtPaymentMethod, c);
        
        
        
        
        
        
        
        btnSubmit = new JButton();
        btnSubmit.setText("Submit");
        c.gridx = 0;
        c.gridy = 10;
        c.gridwidth = 2;
        c.anchor = c.CENTER;
        this.add(btnSubmit, c);
    }
    
    /*
    JTextField txtFirstName;
    JTextField txtLastName;
    JTextField txtNumOfOccupants;
    JTextField txtOccupationDate;
    JTextField txtAddress;
    JTextField txtTab;
    JTextField txtLastRoomNum;
    JTextField txtPhoneNum;
    JTextField txtEmail;
    JTextField txtPaymentMethod;
    */
    
    public JButton getBtnSubmit() {
        return btnSubmit;
    }
    public String getFirstName() {
        return txtFirstName.getText();
    }
    
}
