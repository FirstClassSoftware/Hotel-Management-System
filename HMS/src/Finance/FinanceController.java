/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Yeejkoob Thao
 */
public class FinanceController {

    private FinanceView financeView;
    private FinanceModel financeModel;
    private int selectedFinanceYear;
    public FinanceController(FinanceView view, FinanceModel model) {
        financeView = view;
        financeModel = model;
        this.financeView.addHomeButtonListener(new HomeListener());
    } // End of the FinanceController constructor
    
    class HomeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            financeView.goToHomeView();
        }
    } // End of the HomeListener class
    
     class MyTableModel extends DefaultTableModel {

        @Override
        public void setValueAt(Object value, int row, int col) {
            JTable userTable = financeView.getFinanceTable();
            String columnName = userTable.getColumnName(col);
            int userId = Integer.valueOf(userTable.getValueAt(row, 0).toString());
            
            financeModel.updateFinanceValue(columnName, userId, value, row, col);
            updateFinanceTable();
        }
        
        @Override
        public boolean isCellEditable(int row, int col) {
            if (col == 0 || col == 4) {
                // The first and fourth columns will be uneditable.
                return false;
            } else {
                return true;
            }
        }
    } // End of the MyTableModel class

    public void updateFinanceTable() {
        selectedFinanceYear = 
        ResultSet allUsers = financeModel.getFinanceMonths(yearToObserve);

        ResultSetMetaData allUsersMetaData;
        int totalColumns;

        JTable userTable = financeView.getFinanceTable();

        MyTableModel financeTableModel = new MyTableModel();
        //////////////////////////////////////////////////////////////////////
        try {

            allUsersMetaData = allUsers.getMetaData();
            totalColumns = allUsersMetaData.getColumnCount();

            // Get all the column names from the meta data and add the column
            // names to the table model.
            for (int columnIndex = 1; columnIndex <= totalColumns; columnIndex++) {
                financeTableModel.addColumn(allUsersMetaData.getColumnLabel(columnIndex));
            }

            Object[] row = new Object[totalColumns];

            while (allUsers.next()) {
                for (int currentColumn = 0; currentColumn < totalColumns; currentColumn++) {
                    row[currentColumn] = allUsers.getObject(currentColumn + 1);
                }
                financeTableModel.addRow(row);
            }

            userTable.setModel(financeTableModel);
            
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    } // End of the updateAllUsers method
    
} // End of the FinanceController class
