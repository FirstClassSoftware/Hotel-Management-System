/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

/**
 *
 * @author Yeejkoob Thao
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import home.*;
import AddNewEmployee.*;
import javax.swing.table.TableColumn;
import MoreEmployeeInformationComponents.*;
public class StaffController {
    
    private StaffView staffView;
    private StaffModel staffModel;
    private StaffController staffController;
    
    // Establish a connection with the database and populate the table in
    // the view.
    public StaffController (StaffView view, StaffModel model) {
        staffView = view;
        staffModel = model;
        staffController = this;
        staffView.addHomeButtonListener(new HomeListener());
        staffView.addAddNewEmployeeButtonListener(new AddNewEmployeeListener());
        staffView.addDeleteButtonListener(new DeleteListener());
        staffView.addMoreEmployeeInformationButtonListener(new MoreEmployeeInformationListener());
        updateEmployeeTable();
        
    }
    class HomeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            staffView.goToHomeView();
        }

    } // End of the HomeListener class
    
    class AddNewEmployeeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // Generate a form to fill to make a new employee
            
            AddNewEmployeeView addNewEmployeeForm = new AddNewEmployeeView(staffView, staffModel, staffController);
            AddNewEmployeeModel addNewEmployeeModel = new AddNewEmployeeModel();
            AddNewEmployeeController addNewEmployeeController  = new AddNewEmployeeController(addNewEmployeeForm, addNewEmployeeModel);
            addNewEmployeeForm.setVisible(true);
            
        }

    
    }
    
    class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // Stopped 4/2/16 - Did not get delete to work.
            JTable employeeTable = staffView.getEmployeeTable();
            int userRowSelected = employeeTable.getSelectedRow();
            // column is set to 1 in order to always get the username of the row
            // selected.
            int selectedEmployeeId;

            String noRowSelectedErrorMessage = "Please select an employee row in the table to delete.";
            String confirmDeleteMessage = "Are you sure you want delete this employee?";
            String deleteWarningDialogTitle = "Delete Confirmation";
            //////////////////////////////////////////////////////////////////
            if (userRowSelected == -1) {
                staffView.displayErrorMessage(noRowSelectedErrorMessage);
            } else {
                // Display a delete confirmation
                int yesNoDialogButtons = JOptionPane.YES_NO_OPTION;
                int deleteConfirmationResult = JOptionPane.showConfirmDialog(null,
                        confirmDeleteMessage,
                        deleteWarningDialogTitle,
                        yesNoDialogButtons);
                if (deleteConfirmationResult == JOptionPane.YES_OPTION) {
                    // Delete the user from the database
                    selectedEmployeeId = (int) employeeTable.getValueAt(userRowSelected, 0);
                    staffModel.deleteEmployee(selectedEmployeeId);

                    // Update the view on the deletion
                    updateEmployeeTable();
                }
            }

        }

    } // End of DeleteListener class
    
    class MoreEmployeeInformationListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //  Generate the more information view and components
            MoreEmployeeInformationView moreEmployeeInfoView = new MoreEmployeeInformationView();
            MoreEmployeeInformationModel moreEmployeeInfoModel = new MoreEmployeeInformationModel();
            MoreEmployeeInformationController moreEmployeeInfoController = new MoreEmployeeInformationController(moreEmployeeInfoView, moreEmployeeInfoModel);
            
            moreEmployeeInfoView.setVisible(true);
            
        } // End of the actionPerformed method
        
    } // End of the MoreInformationListener class
    
    class MyTableModel extends DefaultTableModel {

        @Override
        public void setValueAt(Object value, int row, int col) {
            JTable employeeTable = staffView.getEmployeeTable();
            String columnName = employeeTable.getColumnName(col);
            int userId = Integer.valueOf(employeeTable.getValueAt(row, 0).toString());
            
            staffModel.updateEmployeeValue(columnName, userId, value, row, col);
            updateEmployeeTable();
        }
        
        @Override
        public boolean isCellEditable(int row, int col) {
            if (col == 0) {
                // The first column will be uneditable.
                return false;
            } else {
                return true;
            }
        }
    } // End of the MyTableModel class
    
     public void updateEmployeeTable() {

        ResultSet allUsers = staffModel.getAllEmployees();

        ResultSetMetaData allUsersMetaData;
        int totalColumns;

        JTable userTable = staffView.getEmployeeTable();
        MyTableModel userTableModel = new MyTableModel();
        
        try {

            allUsersMetaData = allUsers.getMetaData();
            totalColumns = allUsersMetaData.getColumnCount();

            // Get all the column names from the meta data and add the column
            // names to the table model.
            for (int columnIndex = 1; columnIndex <= totalColumns; columnIndex++) {
                userTableModel.addColumn(allUsersMetaData.getColumnLabel(columnIndex));
            }

            Object[] row = new Object[totalColumns];

            while (allUsers.next()) {
                for (int currentColumn = 0; currentColumn < totalColumns; currentColumn++) {
                    row[currentColumn] = allUsers.getObject(currentColumn + 1);
                }
                userTableModel.addRow(row);
            }

            userTable.setModel(userTableModel);
            ////////////////////////////////////////////////////////////////////
            // Setup the rest of the table everytime the model is updated.
            // I believe the model resetting the model resets the columns. Thus,
            // The code lies here, but I have not tested this assumption.
            ////////////////////////////////////////////////////////////////////
            TableColumn employeeStatusColumn = userTable.getColumnModel().getColumn(3);
            JComboBox  employeeStatusOptions = new JComboBox();
            employeeStatusOptions.addItem("Overtime");
            employeeStatusOptions.addItem("Vacation");
            employeeStatusOptions.addItem("Clocked In");
            employeeStatusOptions.addItem("AWOL");
            employeeStatusOptions.addItem("Clocked Out");
            employeeStatusColumn.setCellEditor(new DefaultCellEditor(employeeStatusOptions));
            ////////////////////////////////////////////////////////////////////
        } catch (SQLException err) {

            //String noRowSelectedErrorMessage = err.getMessage();
            //userView.displayErrorMessage(noRowSelectedErrorMessage);
        }

    } // End of the updateAllUsers method
    
}
