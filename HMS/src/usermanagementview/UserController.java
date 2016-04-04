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

    public void updateUserTable() {

        ResultSet allUsers = userModel.getAllUsers();

        ResultSetMetaData allUsersMetaData;
        int totalColumns;

        JTable userTable = userView.getUserTable();
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

    // Also add in action handlers here for when the user searches for
    // users in the database.
}
