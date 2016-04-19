/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddNewEmployee;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import staff.*;

/**
 *
 * @author Yeejkoob Thao
 */
public class AddNewEmployeeModel {

    private Connection dbConnection;
    private Statement stmt;
    private String SQL;
    private ResultSet rs;
    private Employee newEmployee;
    private byte[] employeeByteArrayEquivalent;

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
                    + "'" + newEmployeeHoursWorked + "',"
                    + "'" + newEmployeeHourlyWage + "',"
                    + "'" + newEmployeeTotalPay + "');";

            stmt.executeUpdate(SQL);
            
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

    } // End of addNewEmployee method

    public void serializeEmployee(String newEmployeeFirstName, String newEmployeeLastName, String hourlyWage) {
        ////////////////////////////////////////////////////////////////////
        // Construct an equivalent Employee Object to serialize into byte array.
        newEmployee = new Employee();
        ResultSet employeeIds = null;
        int employeeId = -1;
        // Get the employee id
        try {
            SQL = "SELECT MAX(EMPLOYEEID) AS EMPLOYEEID FROM EMPLOYEES";
            employeeIds = stmt.executeQuery(SQL);
            employeeId = employeeIds.getInt(1);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        // The above line WORKS! Got the correct employee ID: System.out.println("This is the employee id of the new employee: " + employeeId);
        // Set the employee fields here and initialize an empty PayrollInformaiton and add it to the payrollArray inside employee.
        newEmployee.setEmployeeid(employeeId);
        newEmployee.setFirstName(newEmployeeFirstName);
        newEmployee.setLastName(newEmployeeLastName);
        ArrayList<PayrollInformation> payroll = new <PayrollInformation> ArrayList();
        double newhourlyWage = Double.valueOf(hourlyWage);
        // TESTING: ADDING DUMMY PAYROLL DATA
        for(int i = 0; i < 10; i++) {
            PayrollInformation newPayroll = new PayrollInformation();
            newPayroll.setPayPeriod("3/1/16");
            newPayroll.setClockIn("1:45 PM");
            newPayroll.setClockOut("12:00 AM");
            newPayroll.setHoursWorked(1000);
            newPayroll.setHourlyWage(newhourlyWage);
            newPayroll.setDailyPay(10000);
            payroll.add(newPayroll);
        }
        ////////////////////////////////////////////////////////////////////////
        newEmployee.setPayroll(payroll);
        ////////////////////////////////////////////////////////////////////
        // Now serialize the employee object into the database
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        employeeByteArrayEquivalent = null;
        ObjectOutput out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(newEmployee);
            employeeByteArrayEquivalent = bos.toByteArray();
            // Insert the byte array into the database
            String sqlCmd = "INSERT INTO EMPLOYEE_BYTE_ARRAYS(EMPLOYEEID, FIRSTNAME, LASTNAME, BYTE_ARRAY) VALUES (?, ?, ?, ?);";
            PreparedStatement pstmt = dbConnection.prepareStatement(sqlCmd);
            pstmt.setInt(1, employeeId);
            pstmt.setString(2, newEmployeeFirstName);
            pstmt.setString(3, newEmployeeLastName);
            pstmt.setBytes(4, employeeByteArrayEquivalent);
            pstmt.executeUpdate();

        } catch(Exception err) {
            System.out.println(err.getMessage());
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
                // ignore close exception
            }
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }
    } // End of the serializeEmployee method

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
