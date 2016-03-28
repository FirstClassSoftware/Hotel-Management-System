/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResCust;

import main.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author WhelanMyPC
 */
public class ReservationView extends JPanel {
    
    ReservationModel model;
    
    JPanel contentPane;
    
    JPanel pnlGrid;
    JScrollPane scrTableHold;
    JTable tblMain;
    JPanel pnlTopBtn;
    JPanel pnlBottomBtn;
    
    JButton btnHome;
    JButton btnNewRes;
    JButton btnEditVal;
    JButton btnGoToCust;
    
    JTextField fldSearchEntry;
    JComboBox cmbSearchCategory;
    JButton btnSearch;
    
    private final String[] columnNames = new String[] {"ID", "Floor Number", 
        "Room Number", "Start Date", "End Date", "Customer First Name", 
        "Customer Last Name", "Room Type", "Cost"};
    
    public ReservationView(MainPanelCard c, ReservationModel model) {
        this.model = model;
        contentPane = c;
        initializeComponents();
    }
    
    private void initializeComponents() {
        //model = new ReservationModel();
        String[] cmbSearchCat = columnNames;
        
        pnlGrid = new JPanel();
        scrTableHold = new JScrollPane();
        tblMain = new JTable(model);
        pnlTopBtn = new JPanel();
        pnlBottomBtn = new JPanel();
        btnHome = new JButton();
        btnNewRes = new JButton();
        btnEditVal = new JButton();
        btnGoToCust = new JButton();
        fldSearchEntry = new JTextField(20);
        cmbSearchCategory = new JComboBox(cmbSearchCat);
        btnSearch = new JButton();
        
        setLayout(new BorderLayout());
        
        add(pnlGrid, BorderLayout.CENTER);
        add(pnlTopBtn, BorderLayout.PAGE_START);
        add(pnlBottomBtn, BorderLayout.PAGE_END);
        
        pnlGrid.setLayout(new BorderLayout());
        pnlGrid.add(scrTableHold, BorderLayout.CENTER);
        scrTableHold.setViewportView(tblMain);
        
        btnHome.setText("Home");
        btnNewRes.setText("Add New Reservation");
        btnEditVal.setText("Edit Values");
        btnGoToCust.setText("Go To Customer Screen");
        
        pnlTopBtn.setLayout(new FlowLayout());
        pnlTopBtn.add(btnHome);
        pnlTopBtn.add(btnNewRes);
        pnlTopBtn.add(btnEditVal);
        pnlTopBtn.add(btnGoToCust);
        
        btnSearch.setText("Search");
        
        pnlBottomBtn.setLayout(new FlowLayout());
        pnlBottomBtn.add(fldSearchEntry);
        pnlBottomBtn.add(cmbSearchCategory);
        pnlBottomBtn.add(btnSearch);
        
        //registerListener();
        
    }
    
    public void registerListener(ReservationControl controller) {
        btnHome.addActionListener(controller);
        btnNewRes.addActionListener(controller);
        btnEditVal.addActionListener(controller);
        btnSearch.addActionListener(controller);
        btnGoToCust.addActionListener(controller);
    }
    
    public void goToCust() {
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "Customer Screen");
        //cardLayout.next(contentPane);
    }
    
}
