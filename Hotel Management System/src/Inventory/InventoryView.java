/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import main.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author jessicaluu
 */
public class InventoryView extends JPanel {
    
    JPanel contentPane;
    
    InventoryModel model;
    
    JFrame frame;
    
    JPanel pnlGrid;
    JScrollPane scrTableHold;
    JTable tblMain;
    JPanel pnlTop;
    JPanel pnlBottom;
    AddNewInventory newItemView;
    LowItemPopup lowItemView;
    
    private JButton btnHome;
    private JButton btnNewItem;
    private JButton btnEditItem;
    private JButton btnDeleteItem;
    
    private JProgressBar progressItemStatus;
    
    private JTextField txtSearch;
    private JComboBox cmbSearch;
    private JButton btnSearch;
    
    private String[] columnNames;
    
    public InventoryView(MainPanelCard c, InventoryModel m) {
        this.model = m;
        contentPane = c;
        initializeComponents();
    }
    
    private void initializeComponents() {
        columnNames = model.getColumnNames();
        String[] cmbSearchCat = columnNames;
        newItemView = new AddNewInventory(this);
        lowItemView = new LowItemPopup(this);
        frame = new JFrame();
        
        pnlGrid = new JPanel();
        scrTableHold = new JScrollPane();
        tblMain = new JTable(model);
        pnlTop = new JPanel();
        pnlBottom = new JPanel();
        btnHome = new JButton();
        btnNewItem = new JButton();
        btnEditItem = new JButton();
        btnDeleteItem = new JButton();
        progressItemStatus = new JProgressBar();
        txtSearch = new JTextField(20);
        cmbSearch = new JComboBox(cmbSearchCat);
        btnSearch = new JButton();
        
        setLayout(new BorderLayout());
        
        add(pnlGrid, BorderLayout.CENTER);
        add(pnlTop, BorderLayout.PAGE_START);
        add(pnlBottom, BorderLayout.PAGE_END);
        
        tblMain.setAutoCreateRowSorter(true);
        
        pnlGrid.setLayout(new BorderLayout());
        pnlGrid.add(scrTableHold, BorderLayout.CENTER);
        scrTableHold.setViewportView(tblMain);
        
        btnHome.setText("Home");
        btnNewItem.setText("Add New Item");
        btnEditItem.setText("Edit Item");
        btnDeleteItem.setText("Delete Item");
        
        pnlTop.setLayout(new FlowLayout());
        pnlTop.add(btnHome);
        pnlTop.add(btnNewItem);
        pnlTop.add(btnEditItem);
        pnlTop.add(btnDeleteItem);
        
        btnSearch.setText("Search");
        
        pnlBottom.setLayout(new FlowLayout());
        pnlBottom.add(txtSearch);
        pnlBottom.add(cmbSearch);
        pnlBottom.add(btnSearch);
        
    }
    
    public void registerListener(InventoryController controller) {
        btnHome.addActionListener(controller);
        btnNewItem.addActionListener(controller);
        btnEditItem.addActionListener(controller);
        btnDeleteItem.addActionListener(controller);
        btnSearch.addActionListener(controller);
        
        newItemView.getBtnOK().addActionListener(controller);
        lowItemView.getBtnOK().addActionListener(controller);
    }
    
    public AddNewInventory getNewItemView() {
        return newItemView;
    }
    
    public LowItemPopup getLowItemView() {
        return lowItemView;
    }
    
    public JButton getBtnHome() {
        return btnHome;
    }
    
    public JButton getBtnNewItem() {
        return btnNewItem;
    }
    
    public JButton getBtnEditItem() {
        return btnEditItem;
    }
    
    public JButton getBtnDeleteItem() {
        return btnDeleteItem;
    }
    
    public JButton getBtnSearch() {
        return btnSearch;
    }
    
    public String getTxtSearch() {
        return txtSearch.getText();
    }
    
    public int getCmbSearchColumn() {
        return cmbSearch.getSelectedIndex();
    }
    
    public void showNewItemView() {
        frame.setSize(360, 180);
        frame.setVisible(true);
        newItemView.resetFields();
        frame.add(newItemView);
    }
    
    public void closeView() {
        frame.setVisible(false);
    }
    
    public void showLowItemView() {
        frame.setSize(300, 140);
        frame.setVisible(true);
        frame.add(lowItemView);
    }
    
    public int getSelectedRow() {
        return tblMain.getSelectedRow();
    }
}
