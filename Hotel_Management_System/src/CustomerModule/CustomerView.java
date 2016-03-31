/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerModule;

import main.*;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author WhelanMyPC
 */
public class CustomerView extends JPanel {
    
    JPanel contentPane;
    
    CustomerModel model;
            
    JFrame popupFrame;
    
    JPanel pnlGrid;
    JScrollPane scrTableHold;
    JTable tblMain;
    JPanel pnlTopBtn;
    JPanel pnlBottomBtn;
    AddNewCustView newCustView;
    
    private JButton btnHome;
    private JButton btnNewCust;
    private JButton btnDeleteRow;
    private JButton btnGoToRes;
    private JButton btnRefreshTable;
    
    private JTextField fldSearchEntry;
    private JComboBox cmbSearchCategory;
    private JButton btnSearch;
    
    private String[] columnNames;
    
    public CustomerView(MainPanelCard c, CustomerModel m) {
        
        model = m;
        contentPane = c;
        initializeComponents();
        
    }
    
    private void initializeComponents() {
        columnNames = model.getColumnNames();
        String[] cmbSearchCat = columnNames;
        newCustView = new AddNewCustView(this);
        popupFrame = new JFrame();
        
        
        pnlGrid = new JPanel();
        scrTableHold = new JScrollPane();
        tblMain = new JTable(model);
        pnlTopBtn = new JPanel();
        pnlBottomBtn = new JPanel();
        btnHome = new JButton();
        btnNewCust = new JButton();
        btnDeleteRow = new JButton();
        btnGoToRes = new JButton();
        btnRefreshTable = new JButton();
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
        btnDeleteRow.setText("Delete Row");
        btnGoToRes.setText("Go to Reservations Screen");
        btnRefreshTable.setText("Refresh Table");
        
        pnlTopBtn.setLayout(new FlowLayout());
        pnlTopBtn.add(btnHome);
        pnlTopBtn.add(btnNewCust);
        pnlTopBtn.add(btnDeleteRow);
        pnlTopBtn.add(btnGoToRes);
        pnlTopBtn.add(btnRefreshTable);
        
        btnSearch.setText("Search");
        
        pnlBottomBtn.setLayout(new FlowLayout());
        pnlBottomBtn.add(fldSearchEntry);
        pnlBottomBtn.add(cmbSearchCategory);
        pnlBottomBtn.add(btnSearch);
        
    }
    
    public void registerListener(CustomerControl controller) {
        btnHome.addActionListener(controller);
        btnNewCust.addActionListener(controller);
        btnDeleteRow.addActionListener(controller);
        btnSearch.addActionListener(controller);
        btnGoToRes.addActionListener(controller);
        btnRefreshTable.addActionListener(controller);
        newCustView.getBtnSubmit().addActionListener(controller);
    }
    
    public AddNewCustView getNewCustView() {
        return newCustView;
    }
    
    public JButton getBtnHome() {
        return btnHome;
    }
    
    public JButton getBtnNewCust() {
        return btnNewCust;
    }
    
    public JButton getBtnDeleteRow() {
        return btnDeleteRow;
    }
    
    public JButton getBtnSearch() {
        return btnSearch;
    }
    
    public JButton getBtnGoToRes() {
        return btnGoToRes;
    }
    
    public JButton getBtnRefreshTable() {
        return btnRefreshTable;
    }
    
    public int getComboColumn() {
        return cmbSearchCategory.getSelectedIndex();
    }
    
    public String getFldSearchEntry() {
        return fldSearchEntry.getText();
    }
    
    public void goToRes() {
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "Reservation Screen");
    }
    
    public void showNewCustScreen() {
        //JFrame frame = new JFrame();
        popupFrame.setSize(400, 500);
        popupFrame.setVisible(true);
        //newCustView = new AddNewCustView(this);
        newCustView.resetFields();
        popupFrame.add(newCustView);
    }
    
    public int getSelectedRow() {
        return tblMain.getSelectedRow();
    }
    
    public void closeNewCustScreen() {
        popupFrame.setVisible(false);
    }
    
    public void setTableModel(CustomerTableModelSearch model) {
        tblMain.setModel(model);
    }
    
    public void refreshTableModel() {
        tblMain.setModel(model);
    }
    
    
    
}
