/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResCust;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author WhelanMyPC
 */
public class ReservationView extends JPanel implements ActionListener{
    
    JPanel pnlGrid;
    JPanel pnlTopBtn;
    JPanel pnlBottomBtn;
    JButton btnHome;
    JButton btnNewRes;
    JButton btnEditVal;
    JButton btnGoToCust;
    
    public ReservationView() {
        initializeComponents();
    }
    
    private void initializeComponents() {
        
        pnlGrid = new JPanel();
        pnlTopBtn = new JPanel();
        pnlBottomBtn = new JPanel();
        btnHome = new JButton();
        btnNewRes = new JButton();
        btnEditVal = new JButton();
        btnGoToCust = new JButton();
        
        setLayout(new BorderLayout());
        
        add(pnlGrid, BorderLayout.CENTER);
        add(pnlTopBtn, BorderLayout.PAGE_START);
        add(pnlBottomBtn, BorderLayout.PAGE_END);
        
        btnHome.setText("Home");
        btnNewRes.setText("Add New Reservation");
        btnEditVal.setText("Edit Values");
        
        pnlTopBtn.setLayout(new BoxLayout(pnlTopBtn, BoxLayout.LINE_AXIS));
        pnlTopBtn.add(btnHome);
        pnlTopBtn.add(btnNewRes);
        pnlTopBtn.add(btnEditVal);
        
    }
    
    public void registerListener() {
        btnHome.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnHome) {
            System.exit(0);
        }
        
    }
    
}
