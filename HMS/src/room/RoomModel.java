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
            ///////////////////////////////////////////////////////////////////
            SQL = "CREATE TABLE IF NOT EXISTS ROOMS"
                    + "(ID INTEGER PRIMARY KEY    AUTOINCREMENT,"
                    + " FLOOR INTEGER,"
                    + " ROOM_NUMBER INTEGER unique,"
                    + " ROOM_TYPE TEXT,"
                    + " ROOM_STATUS TEXT,"
                    + " CUSTOMER TEXT,"
                    + " PRICE INTEGER)";

            stmt.executeUpdate(SQL);
            ///////////////////////////////////////////////////////////////////
            SQL = "CREATE TABLE IF NOT EXISTS FLOORS"
                    + "(ID INTEGER PRIMARY KEY    AUTOINCREMENT,"
                    + " FLOOR INTEGER,"
                    + " TOTAL_ROOMS INTEGER)";

            stmt.executeUpdate(SQL);
            ///////////////////////////////////////////////////////////////////
            System.out.println("Successfully connected to the database.");
        } catch (SQLException err) {

            System.out.println(err.getMessage());

        }

    } // End of the RoomModel constructor
    
    public ResultSet getAllRooms() {

        try {

            SQL = "SELECT * FROM ROOMS;";
            rs = stmt.executeQuery(SQL);
            return rs;

        } catch (SQLException err) {

            System.out.println(err.getMessage());
            return null;

        }

    } // End of getAllRooms method
    
    public void updateRoomValue (String columnName, int roomId, Object value, int row, int column) {
        try {
            if(column != 0) {
                stmt.executeUpdate("UPDATE ROOMS SET " + columnName
                        + " = '" + value + "' WHERE ID = " + roomId);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    } // End of the updateRoomValue method
} // End of the RoomModel class
