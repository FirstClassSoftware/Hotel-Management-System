/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResCust;

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
    private JButton btnEditVal;
    private JButton btnGoToRes;
    
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
        
    }
    
    public void registerListener(CustomerControl controller) {
        btnHome.addActionListener(controller);
        btnNewCust.addActionListener(controller);
        btnEditVal.addActionListener(controller);
        btnSearch.addActionListener(controller);
        btnGoToRes.addActionListener(controller);
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
    
    public JButton getBtnEditVal() {
        return btnEditVal;
    }
    
    public JButton getBtnSearch() {
        return btnSearch;
    }
    
    public JButton getBtnGoToRes() {
        return btnGoToRes;
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
        popupFrame.add(newCustView);
    }
    
    public void closeNewCustScreen() {
        popupFrame.setVisible(false);
    }
    
    
    
}
