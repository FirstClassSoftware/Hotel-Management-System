/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import main.*;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.util.regex.PatternSyntaxException;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jessicaluu
 */
public class InventoryView extends JPanel {
    
    JPanel contentPane;
    
    InventoryModel model;
    
    TableRowSorter<InventoryModel> sorter;
    
    JFrame popupFrame;
    
    JPanel pnlGrid;
    JScrollPane scrTableHold;
    JTable tblMain;
    JPanel pnlTop;
    JPanel pnlBottom;
    AddNewInventory newItemView;
    LowItemPopup lowItemView;
    
    private JButton btnHome;
    private JButton btnNewItem;
    private JButton btnDeleteItem;
    //private JButton btnRefreshTable;
    
    private JProgressBar progressItemStatus;
    
    private JTextField txtSearch;
    private JComboBox cmbSearch;
    private JButton btnSearch;
    
    private String[] columnNames;
    
    public InventoryView(MainPanel c, InventoryModel m) {
        model = m;
        contentPane = c;
        initializeComponents();
    }
    
    private void initializeComponents() {
        columnNames = model.getColumnNames();
        String[] cmbSearchCat = columnNames;
        newItemView = new AddNewInventory();

        popupFrame = new JFrame();
        
        pnlGrid = new JPanel();
        scrTableHold = new JScrollPane();
        tblMain = new JTable(model);
        pnlTop = new JPanel();
        pnlBottom = new JPanel();
        btnHome = new JButton();
        btnNewItem = new JButton();
        btnDeleteItem = new JButton();
        
        progressItemStatus = new JProgressBar();
        TableColumn itemStatusColumn = tblMain.getColumnModel().getColumn(4);
        tblMain.getColumn("Item Status").setCellRenderer(new ProgressCellRender());
        
        
        
        
        txtSearch = new JTextField(20);
        cmbSearch = new JComboBox(cmbSearchCat);
        btnSearch = new JButton();
        
        sorter = new TableRowSorter<>(model);
        tblMain.setRowSorter(sorter);
        
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
        btnDeleteItem.setText("Delete Item");
        //btnRefreshTable.setText("Refresh");
        
        pnlTop.setLayout(new FlowLayout());
        pnlTop.add(btnHome);
        pnlTop.add(btnNewItem);
        pnlTop.add(btnDeleteItem);
        
        btnSearch.setText("Search");
        
        pnlBottom.setLayout(new FlowLayout());
        pnlBottom.add(txtSearch);
        pnlBottom.add(cmbSearch);
        pnlBottom.add(btnSearch);
        
    }
    
    public class ProgressCellRender extends JProgressBar implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            double progress = 0;
            Double maxItem = Double.parseDouble(table.getValueAt(row, 2).toString());
            Double currentNumberOfItems = Double.parseDouble(table.getValueAt(row, 1).toString());
            progress = (currentNumberOfItems / maxItem) * 100;
            setValue((int) progress);
            return this;
        }
    }
    
    public void registerListener(InventoryController controller) {
        btnHome.addActionListener(controller);
        btnNewItem.addActionListener(controller);
        btnDeleteItem.addActionListener(controller);
        btnSearch.addActionListener(controller);
        //btnRefreshTable.addActionListener(controller);
        
        newItemView.getBtnOK().addActionListener(controller);
        //lowItemView.getBtnOK().addActionListener(controller);
    }
    
    void displayErrorMessage(String errorMessage) {
        
        JOptionPane.showMessageDialog(this, errorMessage);
    }
    
    public JTable getTableMain() {
        return this.tblMain;
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
    
    public JButton getBtnDeleteItem() {
        return btnDeleteItem;
    }
    
    public JButton getBtnSearch() {
        return btnSearch;
    }
    
    //public JButton getBtnRefreshTable() {
    //    return btnRefreshTable;
    //}
    
    public String getTxtSearch() {
        return txtSearch.getText();
    }
    
    public int getCmbSearchColumn() {
        return cmbSearch.getSelectedIndex();
    }
    
    public void showNewItemView() {
        popupFrame.getContentPane().removeAll();
        popupFrame.setSize(360, 180);
        popupFrame.setVisible(true);
        popupFrame.setLocationRelativeTo(null);
        newItemView.resetFields();
        popupFrame.add(newItemView);
    }
    
    public void closeNewItemView() {
        popupFrame.setVisible(false);
    }
    
    /*public void showLowItemView(String message) {
        frame.getContentPane().removeAll();
        frame.setSize(300, 140);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(lowItemView);
    }*/

    public int getSelectedRow() {
        int row = tblMain.getSelectedRow();
        System.out.println(row);
        return tblMain.getSelectedRow();
    }
    
    public TableRowSorter getSorter() {
        return sorter;
    }
    
    public void setSorter(TableRowSorter sorter) {
        tblMain.setRowSorter(sorter);
    }
    
    public void goToHomeView() {
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "Home View");
    }
}
