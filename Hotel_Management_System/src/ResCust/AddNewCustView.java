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
        this.setLayout(new FlowLayout());
        
        pnlLabel = new JPanel();
        pnlLabel.setLayout(new BoxLayout(pnlLabel, BoxLayout.PAGE_AXIS));
        
        lblFirstName = new JLabel("First Name");
        lblLastName = new JLabel("Last Name");
        lblNumOfOccupants = new JLabel("Number of Occupants");
        lblOccupationDate = new JLabel("Occupation Date");
        lblAddress = new JLabel("Address");
        lblTab = new JLabel("Tab");
        lblLastRoomNum = new JLabel("Last Room Number");
        lblPhoneNum = new JLabel("Phone Number");
        lblEmail = new JLabel("Email Address");
        lblPaymentMethod = new JLabel("Payment Method");
        
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
        
        pnlTextField = new JPanel(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        txtFirstName = new JTextField();
        btnSubmit = new JButton();
        btnSubmit.setText("Submit");
        
        this.add(txtFirstName);
        this.add(btnSubmit);
    }
    
}
