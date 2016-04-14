package usermanagementview;

/**
 *
 * @author Yeejkoob Thao
 */
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserModel {

    private Connection dbConnection;
    private Statement stmt;
    private String SQL;
    private ResultSet rs;

    // UserModel Constructor
    public UserModel() {

        // Establish a connection to the database.
        dbConnection = null;
        stmt = null;
        try {
            //Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:hotelData.db");
            //stmt = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
            //ResultSet.CONCUR_READ_ONLY);
            //stmt = dbConnection.createStatement();
            stmt = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            SQL = "CREATE TABLE IF NOT EXISTS USERS"
                    + "(ID INTEGER PRIMARY KEY    AUTOINCREMENT,"
                    + " USERNAME VARCHAR(255) unique,"
                    + " PASSWORD VARCHAR(255)  unique,"
                    + " USERLEVEL VARCHAR(255),"
                    + " LAST_LOGIN VARCHAR(255))";

            stmt.executeUpdate(SQL);
            System.out.println("Successfully connected to the database.");
        } catch (SQLException err) {

            System.out.println(err.getMessage());

        }
    } // End of the UserModel Constructor

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

    public void addNewUser(String newUsername, String newPassword, String newUserLevel) {

        try {
            SQL = "INSERT INTO USERS (USERNAME, PASSWORD, USERLEVEL)"
                    + "VALUES ('" + newUsername + "', '" + newPassword + "', '" + newUserLevel + "');";
            stmt.executeUpdate(SQL);

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    } // End of addNewUser method

    public boolean deleteUser(String usernameOfUserToDelete) {

        try {
            SQL = "DELETE from USERS where USERNAME = " + '"' + usernameOfUserToDelete + '"';
            stmt.executeUpdate(SQL);
            return true;
        } catch (SQLException err) {
            // Find a way to print out the error or not.
            return false;
        }

    }
    
    public void updateUserValue (String columnName, int userId, Object value, int row, int column) {
        try {
            if(column != 0) {
                stmt.executeUpdate("UPDATE USERS SET " + columnName
                        + " = '" + value + "' WHERE ID = " + userId);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
} // End of the UserModel Class
