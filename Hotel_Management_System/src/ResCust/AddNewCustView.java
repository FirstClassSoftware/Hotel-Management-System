/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResCust;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.BorderLayout;

/**
 *
 * @author Whelan
 */
public class AddNewCustView extends JPanel {
    
    JTextField txtFirstName;
    JButton btnSubmit;
    
    public AddNewCustView() {
        this.setLayout(new BorderLayout());
        
        txtFirstName = new JTextField();
        btnSubmit = new JButton();
        btnSubmit.setText("Submit");
        
        this.add(txtFirstName);
        this.add(btnSubmit);
    }
    
}
