/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservationModule;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 *
 * @author Whelan
 */
public class AddNewResPriceRangeView extends JPanel {
    
    private JLabel lblTitle;
    private JLabel lblMinPrice;
    private JLabel lblMaxPrice;
    
    private JTextField txtMinPrice;
    private JTextField txtMaxPrice;
    
    private JButton btnSubmit;
    
    public AddNewResPriceRangeView() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        Insets topSpaceInset = new Insets(10, 0, 0 ,0);
        c.insets = topSpaceInset;
        
        lblTitle = new JLabel("Please enter Customer price range values to see rooms in the price range: ");
        c.gridx = 0;
        c.gridy = 0;
        this.add(lblMinPrice, c);
        
        lblMinPrice = new JLabel("Please enter Minimum value for price range: ");
        c.gridx = 0;
        c.gridy = 1;
        this.add(lblMinPrice, c);
        
        lblMaxPrice = new JLabel("Please enter Maximum value for price range: ");
        c.gridx = 0;
        c.gridy = 2;
        this.add(lblMaxPrice, c);
        
        txtMinPrice = new JTextField();
        c.gridx = 1;
        c.gridy = 1;
        this.add(txtMinPrice, c);
        
        txtMaxPrice = new JTextField();
        c.gridx = 1;
        c.gridy = 2;
        this.add(txtMaxPrice, c);
        
    }
    
}
