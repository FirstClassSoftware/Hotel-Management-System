/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddNewEmployee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yeejkoob Thao
 */
public class AddNewEmployeeModel {

    private Connection dbConnection;
    private Statement stmt;
    private String SQL;
    private ResultSet rs;

    // UserModel Constructor
    public AddNewEmployeeModel() {

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
    } // End of AddNewEmployeeModel constructor

    public void addNewEmployee(
            String newEmployeeFirstName,
            String newEmployeeLastName,
            String newEmployeeStatus,
            String newEmployeeHoursWorked,
            String newEmployeeHourlyWage,
            String newEmployeeTotalPay
    ) {

        try {

            // Attempt to autoincrement ID field
            SQL = "INSERT INTO EMPLOYEES ("
                    + "FIRSTNAME,"
                    + "LASTNAME,"
                    + "STATUS,"
                    + "HOURS_WORKED,"
                    + "HOURLY_WAGE,"
                    + "TOTAL_PAY)"
                    + "VALUES ("
                    + "'" + newEmployeeFirstName + "', "
                    + "'" + newEmployeeLastName + "', "
                    + "'" + newEmployeeStatus + "',"
                    /*
                    + newEmployeeHoursWorked + "',"
                    + newEmployeeHourlyWage + "',"
                    + newEmployeeTotalPay + ");";
                    */
                    + "'" + newEmployeeHoursWorked + "',"
                    + "'" + newEmployeeHourlyWage + "',"
                    + "'" + newEmployeeTotalPay + "');";
             
            stmt.executeUpdate(SQL);

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    } // End of addNewEmployee method

    public ResultSet getAllEmployees() {

        try {

            SQL = "SELECT * FROM EMPLOYEES;";
            rs = stmt.executeQuery(SQL);
            return rs;

        } catch (SQLException err) {

            System.out.println(err.getMessage());
            return null;

        }

    } // End of getAllEmployees method

    public boolean validateEmployeeFirstName(String newEmployeeFirstName) {
        if (newEmployeeFirstName.equals(null)) {
            return false;
        } else if (newEmployeeFirstName.equals("")) {
            return false;
        } else {
            return true;
        }
    } // End of the validateEmployeeFirstName method

    public boolean validateEmployeeLastName(String newEmployeeLastName) {
        if (newEmployeeLastName.equals(null)) {
            return false;
        } else if (newEmployeeLastName.equals("")) {
            return false;
        } else {
            return true;
        }
    } // End of the validateEmployeeLastName method

    public boolean validateEmployeeStatus(String newEmployeeStatus) {
        if (newEmployeeStatus.equals(null)) {
            return false;
        } else if (newEmployeeStatus.equals("")) {
            return false;
        } else {
            return true;
        }
    } // End of the validateEmployeeStatus method

    public boolean validateEmployeeHoursWorked(String newEmployeeHoursWorked) {
        if (newEmployeeHoursWorked.equals(null)) {
            return false;
        } else if (newEmployeeHoursWorked.equals("")) {
            return false;
        } else {
            try {
                Double.parseDouble(newEmployeeHoursWorked);
            } catch (NumberFormatException wrongNumberFormatException) {
                return false;
            }
            return true;
        }
    } // End of the validateEmployeeHoursWorked method
    
    public boolean validateEmployeeHourlyWage(String newEmployeeHourlyWage) {
        if (newEmployeeHourlyWage.equals(null)) {
            return false;
        } else if (newEmployeeHourlyWage.equals("")) {
            return false;
        } else {
            try {
                Double.parseDouble(newEmployeeHourlyWage);
            } catch (NumberFormatException wrongNumberFormatException) {
                return false;
            }
            return true;
        }
    } // End of the validateEmployeeHourlyWage method
    
    public boolean validateEmployeeTotalPay(String newEmployeeTotalPay) {
        if (newEmployeeTotalPay.equals(null)) {
            return false;
        } else if (newEmployeeTotalPay.equals("")) {
            return false;
        } else {
            try {
                Double.parseDouble(newEmployeeTotalPay);
            } catch (NumberFormatException wrongNumberFormatException) {
                return false;
            }
            return true;
        }
    } // End of the validateEmployeeTotalPay method

} // End of the AddNewEmployeeModel class
