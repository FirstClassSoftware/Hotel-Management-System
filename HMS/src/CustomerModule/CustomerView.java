/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerModule;

import main.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableColumn;

/**
 *
 * @author WhelanMyPC
 */
public class CustomerView extends JPanel {
    
    JPanel contentPane;
    
    CustomerModel model;
    
    TableRowSorter<CustomerModel> sorter;
            
    JFrame popupFrame;
    JFrame errorFrame;
    
    JPanel pnlGrid;
    JScrollPane scrTableHold;
    JTable tblMain;
    JPanel pnlTopBtn;
    JPanel pnlBottomBtn;
    AddNewCustPanel newCustView;
    ErrorPanel errorPanel;
    
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
        newCustView = new AddNewCustPanel();
        errorPanel = new ErrorPanel();
        popupFrame = new JFrame();
        errorFrame = new JFrame();
        
        pnlGrid = new JPanel();
        scrTableHold = new JScrollPane();
        tblMain = new JTable(model);
        TableColumn col = tblMain.getColumnModel().getColumn(0);
        tblMain.removeColumn(col);
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
    
    public void registerListener(CustomerControl controller) {
        btnHome.addActionListener(controller);
        btnNewCust.addActionListener(controller);
        btnDeleteRow.addActionListener(controller);
        btnSearch.addActionListener(controller);
        btnGoToRes.addActionListener(controller);
        btnRefreshTable.addActionListener(controller);
        newCustView.getBtnSubmit().addActionListener(controller);
        errorPanel.getBtnExit().addActionListener(controller);
    }
    
    public AddNewCustPanel getNewCustView() {
        return newCustView;
    }
    
    public ErrorPanel getErrorPanel() {
        return errorPanel;
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
        popupFrame.getContentPane().removeAll();
        popupFrame.setSize(400, 500);
        popupFrame.setVisible(true);
        popupFrame.setLocationRelativeTo(null);
        newCustView.resetFields();
        popupFrame.add(newCustView);
    }
    
    public void closeNewCustScreen() {
        popupFrame.setVisible(false);
    }
    
    public void showNewCustError(String errorMessage) {
        errorFrame.getContentPane().removeAll();
        errorFrame.setSize(400, 200);
        errorFrame.setVisible(true);
        errorFrame.setLocationRelativeTo(null);
        errorPanel.setErrorMessage(errorMessage);
        errorFrame.add(errorPanel);
    }
    
    public void closeErrorFrame() {
        errorFrame.setVisible(false);
    }
    
    public int getSelectedRow() {
        int row = tblMain.getSelectedRow();
        System.out.println(row);
        return tblMain.getSelectedRow();
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
    
    
    
    
    
}
