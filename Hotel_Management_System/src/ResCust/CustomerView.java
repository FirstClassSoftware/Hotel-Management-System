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
public class CustomerView extends JPanel implements ActionListener{
    
    JPanel contentPane;
    
    CustomerModel model;
    
    JPanel pnlGrid;
    JScrollPane scrTableHold;
    JTable tblMain;
    JPanel pnlTopBtn;
    JPanel pnlBottomBtn;
    AddNewCustView newCustView;
    
    JButton btnHome;
    JButton btnNewCust;
    JButton btnEditVal;
    JButton btnGoToRes;
    
    JTextField fldSearchEntry;
    JComboBox cmbSearchCategory;
    JButton btnSearch;
    
    private String[] columnNames;
    
    public CustomerView(MainPanelCard c) {
        
        contentPane = c;
        initializeComponents();
        
    }
    
    private void initializeComponents() {
        model = new CustomerModel();
        columnNames = model.getColumnNames();
        String[] cmbSearchCat = columnNames;
        newCustView = new AddNewCustView();
        
        
        pnlGrid = new JPanel();
        scrTableHold = new JScrollPane();
        tblMain = new JTable(model);
        pnlTopBtn = new JPanel();
        pnlBottomBtn = new JPanel();
        btnHome = new JButton();
        btnNewCust = new JButton();
        btnEditVal = new JButton();
        btnGoToRes = new JButton();
        fldSearchEntry = new JTextField(20);
        cmbSearchCategory = new JComboBox(cmbSearchCat);
        btnSearch = new JButton();
        
        setLayout(new BorderLayout());
        
        add(pnlGrid, BorderLayout.CENTER);
        add(pnlTopBtn, BorderLayout.PAGE_START);
        add(pnlBottomBtn, BorderLayout.PAGE_END);
        
        tblMain.setAutoCreateRowSorter(true);
        
        pnlGrid.setLayout(new BorderLayout());
        pnlGrid.add(scrTableHold, BorderLayout.CENTER);
        scrTableHold.setViewportView(tblMain);
        
        btnHome.setText("Home");
        btnNewCust.setText("Add New Customer");
        btnEditVal.setText("Edit Values");
        btnGoToRes.setText("Go to Reservations Screen");
        
        pnlTopBtn.setLayout(new FlowLayout());
        pnlTopBtn.add(btnHome);
        pnlTopBtn.add(btnNewCust);
        pnlTopBtn.add(btnEditVal);
        pnlTopBtn.add(btnGoToRes);
        
        btnSearch.setText("Search");
        
        pnlBottomBtn.setLayout(new FlowLayout());
        pnlBottomBtn.add(fldSearchEntry);
        pnlBottomBtn.add(cmbSearchCategory);
        pnlBottomBtn.add(btnSearch);
        
        registerListener();
    }
    
    public void registerListener() {
        btnHome.addActionListener(this);
        btnNewCust.addActionListener(this);
        btnEditVal.addActionListener(this);
        btnSearch.addActionListener(this);
        btnGoToRes.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnHome) {
            System.exit(0);
        }
        
        if (e.getSource() == btnGoToRes) {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "Reservation Screen");
        }
        
        if (e.getSource() == btnNewCust) {
            JFrame frame = new JFrame();
            frame.setSize(400, 500);
            frame.setVisible(true);
            frame.add(newCustView);
        }
        
    }
    
}
