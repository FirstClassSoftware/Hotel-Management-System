/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddNewUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;

/**
 *
 * @author Yeejkoob Thao
 */
public class AddNewUserModel {

    private Connection dbConnection;
    private Statement stmt;
    private String SQL;
    private ResultSet rs;

    public AddNewUserModel() {

        // Establish a connection to the database.
        dbConnection = null;
        stmt = null;
        try {

            dbConnection = DriverManager.getConnection("jdbc:sqlite:hotelData.db");

            stmt = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);

        } catch (SQLException err) {

            System.out.println(err.getMessage());

        }

    } // End of the AddNewUserModel constructor

    public ResultSet getAllUsers() {

        try {

            SQL = "SELECT * FROM USERS;";
            rs = stmt.executeQuery(SQL);
            return rs;

        } catch (SQLException err) {

            System.out.println(err.getMessage());
            return null;

        }

    } // End of getAllUsers method

    public boolean validateUsername(String inputUsername) {
        if (inputUsername.equals("")) {
            return false;
        } else {
            try {
                String usernameInDatabase;
                ResultSet allUsers = getAllUsers();
                while (allUsers.next()) {
                    usernameInDatabase = allUsers.getString("USERNAME");
                    if (inputUsername.equals(usernameInDatabase)) {
                        // A duplicate username is found in the database.
                        return false;
                    }
                }

                // There are no duplicates of the input username in the database.
                return true;

            } catch (SQLException err) {

                return false;
            } // End of the try-catch statement
        }

    } // End of the validateUsername method

    public boolean validatePassword(String inputPassword) {
        if (inputPassword.equals("")) {
            return false;
        } else {
            try {
                String passwordInDatabase;
                ResultSet allUsers = getAllUsers();
                while (allUsers.next()) {
                    passwordInDatabase = allUsers.getString("PASSWORD");
                    if (inputPassword.equals(passwordInDatabase)) {
                        // A duplicate username is found in the database.
                        return false;
                    }
                }

                // There are no duplicates of the input username in the database.
                return true;

            } catch (SQLException err) {
                // There is an error connecting to the database.
                return false;
            } // End of the try-catch statement

        }

    } // End of the validatePassword method

    public boolean validateRetypePassword(String inputPassword, String inputRetypePassword) {
        return inputPassword.equals(inputRetypePassword) && !inputRetypePassword.equals("");

    } // End of the validateRetypePassword method

    public void addNewUser(String newUsername, String newPassword, String newUserLevel) {

        try {

            /*
            Working copy
            SQL = "INSERT INTO USERS (ID, USERNAME, PASSWORD, USERLEVEL)"
                    + "VALUES ( 3, '" + newUsername + "', '" + newPassword + "', '" + newUserLevel + "');";
             */
            // Attempt to autoincrement ID field
            SQL = "INSERT INTO USERS (USERNAME, PASSWORD, USERLEVEL)"
                    + "VALUES ('" + newUsername + "', '" + newPassword + "', '" + newUserLevel + "');";
            stmt.executeUpdate(SQL);

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    } // End of addNewUser method
    
    public boolean validateUserLevel(String inputUserLevel) {
    
        if(inputUserLevel.equals("")) {
            return false;
        }
        else {
            return true;
        }
    
    }
    
    public String getUserLevelSelection(ButtonGroup userLevelOptions,
                                        JRadioButton receptionistChoice,
                                        JRadioButton managerChoice,
                                        JRadioButton ownerChoice) {

        
        if(userLevelOptions.isSelected(receptionistChoice.getModel()))
        {
            return receptionistChoice.getActionCommand();
        }
        else if (userLevelOptions.isSelected(managerChoice.getModel())) {
            return managerChoice.getActionCommand();
        }
        else if (userLevelOptions.isSelected(ownerChoice.getModel()))
        {
            return ownerChoice.getActionCommand();
        }
        else
        {
            return "";
        }
        
       
    }

} // End of the AddNewUserModel class
