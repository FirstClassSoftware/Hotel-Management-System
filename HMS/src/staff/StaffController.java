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
        updateEmployeeTable();
        
    }
    class HomeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // Possibly disconnect this panel from the parent frame
            // and connect the home panel to the parent frame.
            
            /*
            HomeView newHomeView = new HomeView();
            HomeModel newHomeModel = new HomeModel();
            HomeController newHomeController = new HomeController(newHomeView, newHomeModel);
            // Add this to the frame.
            JFrame thisFrame = (JFrame) SwingUtilities.getWindowAncestor(userView);
            thisFrame.getContentPane().add(HomeView);
            // Close the StaffView
             */
            // Try to just change the visibility of the Jpanel instead of
            // constructing a totally new HomeView.
            // We need to use a card layout here.
            //userView.setVisible(false);
            //JFrame rootFrame = (JFrame) SwingUtilities.getWindowAncestor(userView);
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
            JTable userTable = staffView.getUserTable();
            int userRowSelected = userTable.getSelectedRow();
            // column is set to 1 in order to always get the username of the row
            // selected.
            int selectedEmployeeId;

            String noRowSelectedErrorMessage = "Please select an employee row in the table to delete.";
            String confirmDeleteMessage = "Are you sure you want delete this employee?";
            String deleteWarningDialogTitle = "Delete Confirmation";
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
                    selectedEmployeeId = (int) userTable.getValueAt(userRowSelected, 1);
                    staffModel.deleteEmployee(selectedEmployeeId);

                    // Update the view on the deletion
                    updateEmployeeTable();
                }
            }

        }

    }
    
     public void updateEmployeeTable() {

        ResultSet allUsers = staffModel.getAllEmployees();

        ResultSetMetaData allUsersMetaData;
        int totalColumns;

        JTable userTable = staffView.getUserTable();
        DefaultTableModel userTableModel = new DefaultTableModel();

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

        } catch (SQLException err) {

            //String noRowSelectedErrorMessage = err.getMessage();
            //userView.displayErrorMessage(noRowSelectedErrorMessage);
        }

    } // End of the updateAllUsers method
    
}
