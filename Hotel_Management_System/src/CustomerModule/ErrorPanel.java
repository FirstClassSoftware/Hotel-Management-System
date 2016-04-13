/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerModule;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * @author Whelan
 */
public class ErrorPanel extends JPanel {
    
    private JLabel lblErrorLine1;
    private JLabel lblErrorLine2;
    private JButton btnExit;
    
    public ErrorPanel() {
        btnExit = new JButton("OK");
    }
    
    public void setErrorMessage(String errorMessage) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.ipadx = 10;
        Insets topSpaceInset = new Insets(10, 0, 0 ,0);
        c.insets = topSpaceInset;
        
        lblErrorLine1 = new JLabel();
        c.gridx = 0;
        c.gridy = 0;
        this.add(lblErrorLine1, c);
        
        lblErrorLine2 = new JLabel();
        c.gridx = 0;
        c.gridy = 1;
        this.add(lblErrorLine2, c);
        
        if(errorMessage.equals("Occupation Date")) {
            lblErrorLine1.setText("Please enter Occupation Date in the correct format");
            lblErrorLine2.setText("MM/dd/YYYY Example 02/04/1987");
        }
        
        //btnExit
        c.gridx = 0;
        c.gridy = 2;
        this.add(btnExit, c);
    }

    public JLabel getLblErrorLine1() {
        return lblErrorLine1;
    }

    public void setLblErrorLine1(JLabel lblErrorLine1) {
        this.lblErrorLine1 = lblErrorLine1;
    }

    public JLabel getLblErrorLine2() {
        return lblErrorLine2;
    }

    public void setLblErrorLine2(JLabel lblErrorLine2) {
        this.lblErrorLine2 = lblErrorLine2;
    }

    public JButton getBtnExit() {
        return btnExit;
    }

    public void setBtnExit(JButton btnExit) {
        this.btnExit = btnExit;
    }
    
}
