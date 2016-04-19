/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservationModule;

import main.*;

import javax.swing.*;
import java.awt.*;
import CustomerModule.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author WhelanMyPC
 */
public class ReservationView extends JPanel {
    
    ReservationModel model;
    CustomerModel custModel;
    
    TableRowSorter<ReservationModel> sorter;
    
    JFrame popupFrame;
    AddNewResChoiceView choiceView;
    AddNewCustPanel newCustView;
    AddNewResFieldsView newResView;
    AddNewResPickCustView pickCustView;
    
    JPanel contentPane;
    
    JPanel pnlGrid;
    JScrollPane scrTableHold;
    JTable tblMain;
    JPanel pnlTopBtn;
    JPanel pnlBottomBtn;
    
    private JButton btnHome;
    private JButton btnNewRes;
    private JButton btnDeleteRow;
    private JButton btnGoToCust;
    
    private JTextField fldSearchEntry;
    private JComboBox cmbSearchCategory;
    private JButton btnSearch;
    
    private String[] columnNames;
    
    public ReservationView(MainPanelCard c, ReservationModel model) {
        this.model = model;
        contentPane = c;
        initializeComponents();
    }
    
    private void initializeComponents() {
        columnNames = model.getColumnNames();
        String[] cmbSearchCat = columnNames;
        custModel = new CustomerModel();
        
        popupFrame = new JFrame();
        choiceView = new AddNewResChoiceView();
        newCustView = new AddNewCustPanel();
        newResView = new AddNewResFieldsView();
        pickCustView = new AddNewResPickCustView(custModel);
        
        pnlGrid = new JPanel();
        scrTableHold = new JScrollPane();
        tblMain = new JTable(model);
        TableColumn col = tblMain.getColumnModel().getColumn(0);
        tblMain.removeColumn(col);
        pnlTopBtn = new JPanel();
        pnlBottomBtn = new JPanel();
        btnHome = new JButton();
        btnNewRes= new JButton();
        btnDeleteRow = new JButton();
        btnGoToCust = new JButton();
        fldSearchEntry = new JTextField(20);
        cmbSearchCategory = new JComboBox(cmbSearchCat);
        btnSearch = new JButton();
        
        sorter = new TableRowSorter<>(model);
        tblMain.setRowSorter(sorter);
        
        setLayout(new BorderLayout());
        
        add(pnlGrid, BorderLayout.CENTER);
        add(pnlTopBtn, BorderLayout.PAGE_START);
        add(pnlBottomBtn, BorderLayout.PAGE_END);
        
        pnlGrid.setLayout(new BorderLayout());
        pnlGrid.add(scrTableHold, BorderLayout.CENTER);
        scrTableHold.setViewportView(tblMain);
        
        getBtnHome().setText("Home");
        getBtnNewRes().setText("Add New Reservation");
        getBtnDeleteRow().setText("Delete Row");
        getBtnGoToCust().setText("Go To Customer Screen");
        
        pnlTopBtn.setLayout(new FlowLayout());
        pnlTopBtn.add(getBtnHome());
        pnlTopBtn.add(getBtnNewRes());
        pnlTopBtn.add(getBtnDeleteRow());
        pnlTopBtn.add(getBtnGoToCust());
        
        getBtnSearch().setText("Search");
        
        pnlBottomBtn.setLayout(new FlowLayout());
        pnlBottomBtn.add(getFldSearchEntry());
        pnlBottomBtn.add(getCmbSearchCategory());
        pnlBottomBtn.add(getBtnSearch());
        
        //registerListener();
        
    }
    
    public void registerListener(ReservationControl controller) {
        getBtnHome().addActionListener(controller);
        getBtnNewRes().addActionListener(controller);
        getBtnDeleteRow().addActionListener(controller);
        getBtnSearch().addActionListener(controller);
        getBtnGoToCust().addActionListener(controller);
        choiceView.getBtnNewCust().addActionListener(controller);
        choiceView.getBtnExistingCust().addActionListener(controller);
        newCustView.getBtnSubmit().addActionListener(controller);
        newResView.getBtnSubmit().addActionListener(controller);
        pickCustView.registerListener(controller);
    }

    public JButton getBtnHome() {
        return btnHome;
    }

    public JButton getBtnNewRes() {
        return btnNewRes;
    }

    public JButton getBtnDeleteRow() {
        return btnDeleteRow;
    }

    public JButton getBtnGoToCust() {
        return btnGoToCust;
    }

    public JTextField getFldSearchEntry() {
        return fldSearchEntry;
    }

    public JComboBox getCmbSearchCategory() {
        return cmbSearchCategory;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }
    
    public int getComboColumn() {
        return cmbSearchCategory.getSelectedIndex();
    }
    
    
    public void goToCust() {
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "Customer Screen");
        //cardLayout.next(contentPane);
    }
    
    public void showNewResChoiceView() {
        popupFrame.getContentPane().removeAll();
        popupFrame.setSize(400, 300);
        popupFrame.setVisible(true);
        popupFrame.setLocationRelativeTo(null);
        //choiceView.resetFields();
        popupFrame.add(choiceView);
        
    }
    
    public int getSelectedRow() {
        int row = tblMain.getSelectedRow();
        System.out.println(row);
        return tblMain.getSelectedRow();
    }
    
    public void refreshTableModel() {
        tblMain.setModel(model);
    }
    
    public AddNewResChoiceView getChoiceView() {
        return choiceView;
    }
    
    public int getValueAtCell(int row, int column) {
        //String idString = (String) tblMain.getValueAt(row, column);
        //int id = Integer.parseInt(idString);
        int id = (Integer) tblMain.getValueAt(row, column);
        return id;
    }
    
    public void showNewCustScreen() {
        popupFrame.getContentPane().removeAll();
        popupFrame.setSize(400, 500);
        popupFrame.setVisible(true);
        popupFrame.setLocationRelativeTo(null);
        newCustView.resetFields();
        popupFrame.add(newCustView);
    }
    
    public AddNewCustPanel getNewCustView() {
        return newCustView;
    }
    
    public void closePopupScreen() {
        popupFrame.setVisible(false);
    }
    
    public void showNewResScreen() {
        popupFrame.getContentPane().removeAll();
        //JFrame popupFrame1 = new JFrame();
        popupFrame.setSize(440, 400);
        popupFrame.setVisible(true);
        popupFrame.setLocationRelativeTo(null);
        newResView.resetFields();
        popupFrame.add(newResView);
    }
    
    public AddNewResFieldsView getNewResView() {
        return newResView;
    }
    
    public TableRowSorter getSorter() {
        return sorter;
    }
    
    public void setSorter(TableRowSorter sorter) {
        //this.sorter = sorter;
        tblMain.setRowSorter(sorter);
    }
    
    public void showPickCustScreen() {
        
        popupFrame.getContentPane().removeAll();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        popupFrame.setSize(xSize,ySize);
        popupFrame.setVisible(true);
        popupFrame.setLocationRelativeTo(null);
      
        popupFrame.add(pickCustView);
    }
    
    public AddNewResPickCustView getPickCustScreen() {
        return pickCustView;
    }
     
    
}
