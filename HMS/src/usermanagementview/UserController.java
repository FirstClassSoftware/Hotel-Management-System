package usermanagementview;

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
import AddNewUser.*;
import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class UserController {

    private UserView userView;
    private UserModel userModel;
    private UserController userController;

    // Establish a connection with the database and populate the table in
    // the view.
    public UserController(UserView view, UserModel model) {
        userView = view;
        userModel = model;
        userController = this;
        userView.addHomeButtonListener(new HomeListener());
        userView.addAddNewUserButtonListener(new AddNewUserListener());
        userView.addDeleteButtonListener(new DeleteListener());
        updateUserTable();

    }

    class AddNewUserListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // Generate a form to fill to make a new user
            AddNewUserView addNewUserForm = new AddNewUserView(userView, userModel, userController);
            AddNewUserModel addNewUserFormModel = new AddNewUserModel();
            AddNewUserController addNewUserController = new AddNewUserController(addNewUserForm, addNewUserFormModel);
            addNewUserForm.setVisible(true);
        }

    } // End of the AddNewUserListener class

    class HomeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            userView.goToHomeView();
        }

    } // End of the HomeListener class

    class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // Stopped 4/2/16 - Did not get delete to work.
            JTable userTable = userView.getUserTable();
            int userRowSelected = userTable.getSelectedRow();
            // column is set to 1 in order to always get the username of the row
            // selected.
            String selectedUsername;

            String noRowSelectedErrorMessage = "Please select a user row in the table to delete.";
            String confirmDeleteMessage = "Are you sure you want delete this user?";
            String deleteWarningDialogTitle = "Delete Confirmation";
            if (userRowSelected == -1) {
                userView.displayErrorMessage(noRowSelectedErrorMessage);
            } else {
                // Display a delete confirmation
                int yesNoDialogButtons = JOptionPane.YES_NO_OPTION;
                int deleteConfirmationResult = JOptionPane.showConfirmDialog(null,
                        confirmDeleteMessage,
                        deleteWarningDialogTitle,
                        yesNoDialogButtons);
                if (deleteConfirmationResult == JOptionPane.YES_OPTION) {
                    // Delete the user from the database
                    selectedUsername = userTable.getValueAt(userRowSelected, 1).toString();
                    userModel.deleteUser(selectedUsername);

                    // Update the view on the deletion
                    updateUserTable();
                }
            }

        }

    } // End of DeleteListener class

    /*
    class TableEditListener implements TableModelListener {

        @Override
        public void tableChanged(TableModelEvent e) {
            int rowIndex = e.getFirstRow(); // Gets the first row that is changed
            int columnIndex = e.getColumn(); // Get the column that is changed
            TableModel modelOfEditedTable = (TableModel) e.getSource();
            //Object data = modelOfEditedTable.getValueAt(rowIndex, columnIndex); // store the new changed data
            System.out.println(String.valueOf(rowIndex));
            // Commit these changes into the database
            String editedColumnName = modelOfEditedTable.getColumnName(columnIndex);
            // Maybe think about making a save changes button instead.
        }

    }
     */
    class MyTableModel extends DefaultTableModel {

        @Override
        public void setValueAt(Object value, int row, int col) {
            JTable userTable = userView.getUserTable();
            String columnName = userTable.getColumnName(col);
            int userId = Integer.valueOf(userTable.getValueAt(row, 0).toString());
            
            userModel.updateUserValue(columnName, userId, value, row, col);
            updateUserTable();
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
    }

    public void updateUserTable() {

        ResultSet allUsers = userModel.getAllUsers();

        ResultSetMetaData allUsersMetaData;
        int totalColumns;

        JTable userTable = userView.getUserTable();
        //DefaultTableModel userTableModel = new DefaultTableModel();
        MyTableModel userTableModel = new MyTableModel();
        // Add a new table model listener here too.
        //userTableModel.addTableModelListener(new TableEditListener());
        //////////////////////////////////////////////////////////////////////
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

    // Also add in action handlers here for when the user searches for
    // users in the database.
}
