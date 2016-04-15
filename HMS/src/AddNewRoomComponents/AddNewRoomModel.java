/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddNewRoomComponents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yeejkoob Thao
 */
public class AddNewRoomModel {

    private Connection dbConnection;
    private Statement stmt;
    private String SQL;
    private ResultSet rs;

    // AddNewRoomModel Constructor
    public AddNewRoomModel() {

        // Establish a connection to the database.
        dbConnection = null;
        stmt = null;
        try {

            dbConnection = DriverManager.getConnection("jdbc:sqlite:hotelData.db");

            stmt = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);

            System.out.println("Successfully connected to the database.");
        } catch (SQLException err) {

            System.out.println(err.getMessage());

        }
    } // End of AddNewRoomModel constructor

    public void addNewRoom(
            int newRoomfloor,
            int newRoomNumber,
            String newRoomType,
            int newRoomPrice
    ) {
        try {

            // Attempt to autoincrement ID field
            SQL = "INSERT INTO ROOMS ("
                    + "FLOOR,"
                    + "ROOM_NUMBER,"
                    + "ROOM_TYPE,"
                    + "PRICE)"
                    + "VALUES ("
                    + newRoomfloor + ", "
                    + newRoomNumber + ", "
                    + "'" + newRoomType + "',"
                    + newRoomPrice + ");";

            stmt.executeUpdate(SQL);

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    } // End of addNewRoom method

    public boolean validateFloorNumber(String floorNumber) {
        if (floorNumber.equals("")) {
            return false;
        }
        try {
            Integer.parseInt(floorNumber);
            return true;
        } catch (NumberFormatException wrongNumberFormatException) {
            return false;
        }

    } // End of the valdidateFloorNumber method

    public boolean validateRoomNumber(String roomNumber) {
        if (roomNumber.equals("")) {
            return false;
        }
        try {
            Integer.parseInt(roomNumber);
            return true;
        } catch (NumberFormatException wrongNumberFormatException) {
            return false;
        }

    } // End of the validateRoomNumber method

    public boolean validateRoomPrice(String roomPrice) {
        if (roomPrice.equals("")) {
            return false;
        }
        try {
            Integer.parseInt(roomPrice);
            return true;
        } catch (NumberFormatException wrongNumberFormatException) {
            return false;
        }

    } // End of the validateRoomPrice method

}
