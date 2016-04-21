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
import AddNewFinanceYearComponents.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Yeejkoob Thao
 */
public class FinanceController {

    private FinanceView financeView;
    private FinanceModel financeModel;
    private int selectedFinanceYear;
    private FinanceController financeController;

    public FinanceController(FinanceView view, FinanceModel model) {
        financeView = view;
        financeModel = model;
        financeController = this;
        JComboBox financeYearComboBox = financeView.getFinanceYearComboBox();
        financeModel.setFinanceYearComboBox(financeYearComboBox);
        this.financeView.addHomeButtonListener(new HomeListener());
        financeYearComboBox.addActionListener(new SelectNewYearListener());
        this.financeView.addAddNewFinanceYearButtonListener(new AddNewFinanceYearListener());
        this.financeView.addDeleteButtonListener(new DeleteListener());
        this.financeView.getUserDefinedExpensesField().addActionListener(new CalculateProfitListener());
        this.financeView.getUserDefinedRevenueField().addActionListener(new CalculateProfitListener());
        this.financeView.addCalculateButtonListener(new CalculateProfitListener());
        updateFinanceTable();
    } // End of the FinanceController constructor

    class CalculateProfitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ////////////////////////////////////////////////////////////////////
            // Now update the yearlyProft field
            JTable financeTable = financeView.getFinanceTable();
            JTextField yearlyProfit = financeView.getYearlyProfitField();
            JTextField userDefinedExpensesField = financeView.getUserDefinedExpensesField();
            JTextField userDefinedRevenueField = financeView.getUserDefinedRevenueField();
            double sumOfMonthlyNetProfits = 0;
            double sumOfYearlyProfits = 0;
            try {
                double userDefinedExpenses = Double.parseDouble(userDefinedExpensesField.getText());
                double userDefinedRevenue = Double.parseDouble(userDefinedRevenueField.getText());

                int totalNumberOfRows = financeTable.getModel().getRowCount();
                for (int rowNumber = 0; rowNumber < totalNumberOfRows; rowNumber++) {
                    double monthlyNetProfit = Double.parseDouble(financeTable.getModel().getValueAt(rowNumber, 5).toString());
                    sumOfMonthlyNetProfits += monthlyNetProfit;
                }

                sumOfYearlyProfits = sumOfMonthlyNetProfits + userDefinedRevenue - userDefinedExpenses;
                yearlyProfit.setText(sumOfYearlyProfits+"");

            } catch (NumberFormatException err) {
                financeView.displayErrorMessage("You did not enter in a number value.");
            }
            ////////////////////////////////////////////////////////////////////
        }
    
    }
    
    class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // Display a delete confirmation
            String confirmDeleteMessage = "Are you sure you want to delete this year?";
            String deleteWarningDialogTitle = "Delete Financial Year Confirmation";
            int yesNoDialogButtons = JOptionPane.YES_NO_OPTION;
            int deleteConfirmationResult = JOptionPane.showConfirmDialog(null,
                    confirmDeleteMessage,
                    deleteWarningDialogTitle,
                    yesNoDialogButtons);
            if (deleteConfirmationResult == JOptionPane.YES_OPTION) {
                // Delete the user from the database
                JComboBox financeYearComboBox = financeView.getFinanceYearComboBox();
                selectedFinanceYear = Integer.parseInt(financeView.getFinanceYearComboBox().getSelectedItem().toString());
                financeModel.deleteYearAndMonths(selectedFinanceYear);
                financeModel.deleteFinanceYearFromComboBox(financeYearComboBox, selectedFinanceYear);
                updateFinanceTable();
            }
        } // End of the actionPerformed method

    } // End of the DeleteListener class

    class HomeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            financeView.goToHomeView();
        }
    } // End of the HomeListener class

    class SelectNewYearListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            updateFinanceTable();
        }

    }

    class AddNewFinanceYearListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddNewFinanceYearView addNewFinanceView = new AddNewFinanceYearView(financeView, financeModel, financeController);
            AddNewFinanceYearModel addNewFinanceModel = new AddNewFinanceYearModel();
            AddNewFinanceYearController addNewFinanceController = new AddNewFinanceYearController(addNewFinanceView, addNewFinanceModel);
            addNewFinanceView.setVisible(true);
        }

    }

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
            return false; // None of the cells are editable
        }
    } // End of the MyTableModel class 

    public void updateFinanceTable() {
        selectedFinanceYear = Integer.parseInt(financeView.getFinanceYearComboBox().getSelectedItem().toString());
        ResultSet financeMonths = financeModel.getFinanceMonths(selectedFinanceYear);

        ResultSetMetaData allUsersMetaData;
        int totalColumns;

        JTable financeTable = financeView.getFinanceTable();

        MyTableModel financeTableModel = new MyTableModel();
        //////////////////////////////////////////////////////////////////////
        try {

            allUsersMetaData = financeMonths.getMetaData();
            totalColumns = allUsersMetaData.getColumnCount();

            // Get all the column names from the meta data and add the column
            // names to the table model.
            for (int columnIndex = 1; columnIndex <= totalColumns; columnIndex++) {
                financeTableModel.addColumn(allUsersMetaData.getColumnLabel(columnIndex));
            }

            Object[] row = new Object[totalColumns];

            while (financeMonths.next()) {
                for (int currentColumn = 0; currentColumn < totalColumns; currentColumn++) {
                    row[currentColumn] = financeMonths.getObject(currentColumn + 1);
                }
                financeTableModel.addRow(row);
            }

            financeTable.setModel(financeTableModel);
            financeTable.getTableHeader().setReorderingAllowed(false);
            
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    } // End of the updateAllUsers method

} // End of the FinanceController class
