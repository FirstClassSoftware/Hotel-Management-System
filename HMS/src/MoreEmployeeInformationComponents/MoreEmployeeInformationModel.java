/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoreEmployeeInformationComponents;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import staff.Employee;
import staff.PayrollInformation;

/**
 *
 * @author Yeejkoob Thao
 */
public class MoreEmployeeInformationModel {

    private Connection dbConnection;
    private Statement stmt;
    private String SQL;
    private ResultSet rs;

    public MoreEmployeeInformationModel() {
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
    } // End of the MoreEmployeeInformationModel constructor
    
    public Employee deserializeEmployee(int employeeId) {
        ////////////////////////////////////////////////////////////////////////
        // Read back out the bytearray from the database.
        ResultSet rs = null;
        byte[] dbBytes = null;
        try {
            String sqlCmd = "SELECT BYTE_ARRAY FROM EMPLOYEE_BYTE_ARRAYS WHERE EMPLOYEEID = ?";
            PreparedStatement pstmt = dbConnection.prepareStatement(sqlCmd);
            pstmt.setLong(1, employeeId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dbBytes = rs.getBytes(1);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        
        ByteArrayInputStream bis = new ByteArrayInputStream(dbBytes);
        ObjectInput in = null;
        try {
            in = new ObjectInputStream(bis);
            Object o = in.readObject();
            Employee currentEmployee = (Employee) o;
            return currentEmployee;
        } catch(Exception err) {
            System.out.println(err.getMessage());
        } finally {
            try {
                bis.close();
            } catch (IOException ex) {
                // ignore close exception
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                // ignore close exception
            }
        }
        return null;
    } // End of the deserializeEmployee method
    
    
} // End of the MoreEmployeeInformationModel class
