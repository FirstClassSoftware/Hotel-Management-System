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

import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;

/**
 *
 * @author Whelan
 */
public class AddNewCustView extends JPanel {
    
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
    
    
    public AddNewCustView() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        //pnlLabel = new JPanel();
        //pnlLabel.setLayout(new BoxLayout(pnlLabel, BoxLayout.PAGE_AXIS));
        
        lblFirstName = new JLabel("First Name");
        c.gridx = 0;
        c.gridy = 0;
        this.add(lblFirstName, c);
        
        lblLastName = new JLabel("Last Name");
        lblNumOfOccupants = new JLabel("Number of Occupants");
        lblOccupationDate = new JLabel("Occupation Date");
        lblAddress = new JLabel("Address");
        lblTab = new JLabel("Tab");
        lblLastRoomNum = new JLabel("Last Room Number");
        lblPhoneNum = new JLabel("Phone Number");
        lblEmail = new JLabel("Email Address");
        lblPaymentMethod = new JLabel("Payment Method");
        
        
        
        /*
        pnlLabel.add(lblFirstName);
        pnlLabel.add(lblLastName);
        pnlLabel.add(lblNumOfOccupants);
        pnlLabel.add(lblOccupationDate);
        pnlLabel.add(lblAddress);
        pnlLabel.add(lblTab);
        pnlLabel.add(lblLastRoomNum);
        pnlLabel.add(lblPhoneNum);
        pnlLabel.add(lblEmail);
        pnlLabel.add(lblPaymentMethod);
        
        this.add(pnlLabel);
        */
        
        //pnlTextField = new JPanel();
        //pnlTextField.setLayout(new BoxLayout(pnlTextField, BoxLayout.PAGE_AXIS));
        
        int txtSize = 20;
        txtFirstName = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 0;
        this.add(txtFirstName, c);
        
        txtLastName = new JTextField(txtSize);
        txtNumOfOccupants = new JTextField(txtSize);
        txtOccupationDate = new JTextField(txtSize);
        txtAddress = new JTextField(txtSize);
        txtTab = new JTextField(txtSize);
        txtLastRoomNum = new JTextField(txtSize);
        txtPhoneNum = new JTextField(txtSize);
        txtEmail = new JTextField(txtSize);
        txtPaymentMethod = new JTextField(txtSize);
        
        /*
        pnlTextField.add(txtFirstName);
        pnlTextField.add(txtLastName);
        pnlTextField.add(txtNumOfOccupants);
        pnlTextField.add(txtOccupationDate);
        pnlTextField.add(txtAddress);
        pnlTextField.add(txtTab);
        pnlTextField.add(txtLastRoomNum);
        pnlTextField.add(txtPhoneNum);
        pnlTextField.add(txtEmail);
        pnlTextField.add(txtPaymentMethod);
        
        this.add(pnlTextField);
        */
        
        btnSubmit = new JButton();
        btnSubmit.setText("Submit");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        //c.fill = GridBagConstraints.HORIZONTAL;
        this.add(btnSubmit, c);
    }
    
}
