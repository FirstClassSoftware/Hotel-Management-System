/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import main.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jessicaluu
 */
public class InventoryView extends JPanel implements ActionListener {
    
    JPanel contentPane;
    
    InventoryModel model;
    
    JPanel pnlGrid;
    JScrollPane scrTableHold;
    JTable tblMain;
    JPanel pnlTopBtn;
    JPanel pnlBottomBtn;
    
    JButton btnHome;
    JButton btnNewItem;
    JButton btnEditVal;
    
    JProgressBar progressItemStatus;
    
    JTextField fldSearchEntry;
    JComboBox cmbSearchCategory;
    JButton btnSearch;
    
    private final String[] columnNames = new String[] {"Item Name", 
        "Current Amount", "Maximum Amount", "Item Cost", "Item Status"};
    
    public InventoryView(MainPanelCard c) {
        contentPane = c;
        initializeComponents();
    }
    
    private void initializeComponents() {
        model = new InventoryModel();
        String[] cmbSearchCat = columnNames;
        
        pnlGrid = new JPanel();
        scrTableHold = new JScrollPane();
        tblMain = new JTable(model);
        pnlTopBtn = new JPanel();
        pnlBottomBtn = new JPanel();
        btnHome = new JButton();
        btnNewItem = new JButton();
        btnEditVal = new JButton();
        progressItemStatus = new JProgressBar();
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
        btnNewItem.setText("Add New Inventory");
        btnEditVal.setText("Edit Values");
        
        pnlTopBtn.setLayout(new FlowLayout());
        pnlTopBtn.add(btnHome);
        pnlTopBtn.add(btnNewItem);
        pnlTopBtn.add(btnEditVal);
        
        btnSearch.setText("Search");
        
        pnlBottomBtn.setLayout(new FlowLayout());
        pnlBottomBtn.add(fldSearchEntry);
        pnlBottomBtn.add(cmbSearchCategory);
        pnlBottomBtn.add(btnSearch);
        
        registerListener();
        
    }
    
    public void registerListener() {
        btnHome.addActionListener(this);
        btnNewItem.addActionListener(this);
        btnEditVal.addActionListener(this);
        btnSearch.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnHome) {
            System.exit(0);
        }
        
        if (e.getSource() == btnNewItem) {
            AddNewInventory addItem = new AddNewInventory();
            addItem.setVisible(true);
        }
        
    }
    
}
