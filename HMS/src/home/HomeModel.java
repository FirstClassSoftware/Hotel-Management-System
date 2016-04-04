
package home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yeejkoob Thao
 */
public class HomeModel {
    
    private Connection dbConnection;
    private Statement stmt;
    private String SQL;
    private ResultSet rs;
    
    public HomeModel() {
        
        // Establish a connection to the database.
        dbConnection = null;
        stmt = null;
        try {
            //Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:hotelData.db");
            //stmt = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    //ResultSet.CONCUR_READ_ONLY);
            //stmt = dbConnection.createStatement();
            stmt = dbConnection.createStatement( ResultSet.TYPE_FORWARD_ONLY, 
                    ResultSet.CONCUR_READ_ONLY);
            
            
            System.out.println("Successfully connected to the database.");
            
        } catch (SQLException err) {

            System.out.println(err.getMessage());

        }
                   
    } // End of the HomeModel Constructor
    
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
    
} // End of the HomeModel Class
