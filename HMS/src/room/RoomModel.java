/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package room;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yeejkoob Thao
 */
public class RoomModel {

    ///////////////////////////////////////////////////////////////////////////
    private Connection dbConnection;
    private Statement stmt;
    private String SQL;
    private ResultSet rs;

    ///////////////////////////////////////////////////////////////////////////
    public RoomModel() {
        
        // Establish a connection to the database.
        dbConnection = null;
        stmt = null;
        try {
            
            dbConnection = DriverManager.getConnection("jdbc:sqlite:hotelData.db");
            
            stmt = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            SQL = "CREATE TABLE IF NOT EXISTS ROOMS"
                    + "(ID INTEGER PRIMARY KEY    AUTOINCREMENT,"
                    + " ROOM_NUMBER INTEGER unique,"
                    + " TYPE_OF_ROOM TEXT  unique,"
                    + " USERLEVEL VARCHAR(255),"
                    + " LAST_LOGIN VARCHAR(255))";

            stmt.executeUpdate(SQL);
            System.out.println("Successfully connected to the database.");
        } catch (SQLException err) {

            System.out.println(err.getMessage());

        }

    } // End of the RoomModel constructor
} // End of the RoomModel class
