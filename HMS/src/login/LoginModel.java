package login;

/**
 *
 * @author Yeejkoob Thao
 */
import java.sql.*;
import java.util.Date;

public class LoginModel {

    private Connection dbConnection;
    private Statement stmt;
    private String SQL;
    private ResultSet allUsers;

    public LoginModel() {

        // Establish a database connection
        dbConnection = null;
        stmt = null;
        try {

            //Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:hotelData.db");
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

            // Catch the error in the event of a database connectio error.
            // generate a pop-up error message. The message should already be 
            // existing in the view.
            System.out.println(err.getMessage());

        }

    }// end of the LoginModel constructor

    public ResultSet getAllUsers() {

        try {
            //SQL = "INSERT INTO USERS (USERNAME, PASSWORD, USERLEVEL)" 
            //        + "VALUES ('admin', 'admin', 'Owner');";
            //stmt.executeUpdate(SQL);

            SQL = "SELECT * FROM USERS;";
            allUsers = stmt.executeQuery(SQL);
            return allUsers;

        } catch (SQLException err) {

            System.out.println(err.getMessage());
            return null;

        }

    } // End of getAllUsers method

    public boolean validateUser(String inputUsername, String inputPassword) {

        try {

            ResultSet allUsers = getAllUsers();
            String currentUsername;
            String currentPassword;

            while (allUsers.next()) {

                currentUsername = allUsers.getString("USERNAME");
                currentPassword = allUsers.getString("PASSWORD");

                if (currentUsername.equals(inputUsername)) {

                    if (currentPassword.equals(inputPassword)) {

                        return true;

                    }
                }
            } // end of the while loop

            return false;

        } catch (SQLException err) {

            System.out.println(err.getMessage());
            return false;

        }

    }// End of the validateUser method

    public String getEffectiveUserLevel(String inputUsername) {

        String effectiveUserLevel = null;
        try {

            ResultSet allUsers = getAllUsers();
            while (allUsers.next()) {

                if (allUsers.getString("USERNAME").equals(inputUsername)) {

                    effectiveUserLevel = allUsers.getString("USERLEVEL");
                    return effectiveUserLevel;
                }

            } // End of the while loop

            return effectiveUserLevel;
            
        } catch (SQLException err) {

            return effectiveUserLevel;
            
        }

    }
    
    public void recordUserLoginTime(String loggedInUsername) {
    
        String currentUserLoginTime = new Date().toString();
        try {
            SQL = "UPDATE USERS set LAST_LOGIN = " + '"' + currentUserLoginTime + '"' + " where USERNAME=" + '"' + loggedInUsername + '"' + ";";
            stmt.executeUpdate(SQL);
        }
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
    
    }

}// End of the LoginModel class
