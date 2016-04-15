/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservationModule;

import CustomerModule.*;
//import main.*;

import javax.swing.*;
import java.awt.*;
import java.util.regex.PatternSyntaxException;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author WhelanMyPC
 */
public class PickCustView extends JPanel {
    
    //JPanel contentPane;
    
    CustomerModel model;
    
    TableRowSorter<CustomerModel> sorter;
            
    JFrame popupFrame;
    
    JPanel pnlGrid;
    JScrollPane scrTableHold;
    JTable tblMain;
    JPanel pnlTopBtn;
    JPanel pnlBottomBtn;
    //AddNewCustView newCustView;
    
    //private JButton btnHome;
    //private JButton btnNewCust;
    //private JButton btnDeleteRow;
    //private JButton btnGoToRes;
    //private JButton btnRefreshTable;
    
    private JTextField fldSearchEntry;
    private JComboBox cmbSearchCategory;
    private JButton btnSearch;
    
    private JButton btnSelectCustomer;
    
    private String[] columnNames;
    
    public PickCustView(/*MainPanelCard c,*/ CustomerModel m) {
        
        model = m;
        //contentPane = c;
        initializeComponents();
        
    }
    
    private void initializeComponents() {
        columnNames = model.getColumnNames();
        
        model.setIsEditable(false);
        String[] cmbSearchCat = columnNames;
        //newCustView = new AddNewCustView();
        popupFrame = new JFrame();
        
        pnlGrid = new JPanel();
        scrTableHold = new JScrollPane();
        tblMain = new JTable(model);
        pnlTopBtn = new JPanel();
        pnlBottomBtn = new JPanel();
        btnSelectCustomer = new JButton();
        /*btnHome = new JButton();
        btnNewCust = new JButton();
        btnDeleteRow = new JButton();
        btnGoToRes = new JButton();
        btnRefreshTable = new JButton();*/
        fldSearchEntry = new JTextField(20);
        cmbSearchCategory = new JComboBox(cmbSearchCat);
        btnSearch = new JButton();
        
        sorter = new TableRowSorter<>(model);
        tblMain.setRowSorter(sorter);
        
        setLayout(new BorderLayout());
        
        add(pnlGrid, BorderLayout.CENTER);
        add(pnlTopBtn, BorderLayout.PAGE_START);
        add(pnlBottomBtn, BorderLayout.PAGE_END);
        
        tblMain.setAutoCreateRowSorter(true);
        
        pnlGrid.setLayout(new BorderLayout());
        pnlGrid.add(scrTableHold, BorderLayout.CENTER);
        scrTableHold.setViewportView(tblMain);
        
        btnSelectCustomer.setText("Select Customer");
        /*btnHome.setText("Home");
        btnNewCust.setText("Add New Customer");
        btnDeleteRow.setText("Delete Row");
        btnGoToRes.setText("Go to Reservations Screen");
        btnRefreshTable.setText("Refresh Table");*/
        
        pnlTopBtn.setLayout(new FlowLayout());
        pnlTopBtn.add(btnSelectCustomer);
        /*pnlTopBtn.add(btnHome);
        pnlTopBtn.add(btnNewCust);
        pnlTopBtn.add(btnDeleteRow);
        pnlTopBtn.add(btnGoToRes);*/
        //pnlTopBtn.add(btnRefreshTable);
        
        btnSearch.setText("Search");
        
        pnlBottomBtn.setLayout(new FlowLayout());
        pnlBottomBtn.add(fldSearchEntry);
        pnlBottomBtn.add(cmbSearchCategory);
        pnlBottomBtn.add(btnSearch);
        
        /*
        try {
                    sorter.setRowFilter(RowFilter.regexFilter(fldSearchEntry.getText(), 1));
                } catch (PatternSyntaxException pse) {
                    System.err.println("Bad regex pattern");
                }
                */
    }
    
    public void registerListener(ReservationControl controller) {
        btnSearch.addActionListener(controller);
        btnSelectCustomer.addActionListener(controller);
        
        /*btnHome.addActionListener(controller);
        btnNewCust.addActionListener(controller);
        btnDeleteRow.addActionListener(controller);
        btnGoToRes.addActionListener(controller);
        btnRefreshTable.addActionListener(controller);
        newCustView.getBtnSubmit().addActionListener(controller);*/
    }
    
    /*
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
    */
    public JButton getBtnSearch() {
        return btnSearch;
    }
    
    public JButton getBtnSelectCustomer() {
        return btnSelectCustomer;
    }
    /*
    public JButton getBtnGoToRes() {
        return btnGoToRes;
    }
    
    public JButton getBtnRefreshTable() {
        return btnRefreshTable;
    }
    */
    public int getComboColumn() {
        return cmbSearchCategory.getSelectedIndex();
    }
    
    public JTextField getFldSearchEntry() {
        return fldSearchEntry;
    }
    /*
    public void goToRes() {
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "Reservation Screen");
    }
    
    public void showNewCustScreen() {
        popupFrame.setSize(400, 500);
        popupFrame.setVisible(true);
        popupFrame.setLocationRelativeTo(null);
        newCustView.resetFields();
        popupFrame.add(newCustView);
    }
    */
    public int getSelectedRow() {
        //int row = tblMain.getSelectedRow();
        //System.out.println(row);
        return tblMain.getSelectedRow();
    }
    
    public void closeNewCustScreen() {
        popupFrame.setVisible(false);
    }
    
    public Object getTableModel() {
        return tblMain.getModel();
    }
    
    public void refreshTableModel() {
        tblMain.setModel(model);
    }
    
    public TableRowSorter getSorter() {
        return sorter;
    }
    
    public void setSorter(TableRowSorter sorter) {
        //this.sorter = sorter;
        tblMain.setRowSorter(sorter);
    }
    
    public int getValueAtCell(int row, int column) {
        String idString = (String) tblMain.getValueAt(row, column);
        int id = Integer.parseInt(idString);
        return id;
    }
    
    public Object getObjectAtCell(int row ,int column) {
        Object object = tblMain.getValueAt(row, column);
        return object;
    }
    
}
    
    
    

