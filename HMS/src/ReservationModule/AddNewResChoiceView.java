/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservationModule;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 *
 * @author Whelan
 */
public class AddNewResChoiceView extends JPanel {
    
    private final JButton newCust;
    private final JButton existingCust;
    
    public AddNewResChoiceView() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        newCust = new JButton("Add Reservation for New Customer");
        existingCust = new JButton("Add Reservation for Existing Customer");
        
        Insets topSpaceInset = new Insets(10, 0, 0 ,0);
        c.insets = topSpaceInset;
        
        c.gridx = 1;
        c.gridy = 1;
        this.add(newCust, c);
        
        c.gridy = 2;
        this.add(existingCust, c);
        
    }

    public JButton getBtnNewCust() {
        return newCust;
    }

    public JButton getBtnExistingCust() {
        return existingCust;
    }
}
