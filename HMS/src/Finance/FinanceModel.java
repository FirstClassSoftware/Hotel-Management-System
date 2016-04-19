/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yeejkoob Thao
 */
public class FinanceModel {

    private Connection dbConnection;
    private Statement stmt;
    private String SQL;
    private ResultSet rs;
    
    public FinanceModel() {
        // Establish a connection to the database.
        dbConnection = null;
        stmt = null;
        try {
            dbConnection = DriverManager.getConnection("jdbc:sqlite:hotelData.db");
            stmt = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            SQL = "CREATE TABLE IF NOT EXISTS FINANCE_MONTH"
                    + "(ID INTEGER PRIMARY KEY,"
                    + " YEAR INTEGER,"
                    + " MONTH TEXT,"
                    + " REVENUE REAL,"
                    + " EXPENSES REAL,"
                    + " NET_PROFIT REAL)";

            stmt.executeUpdate(SQL);
            ////////////////////////////////////////////////////////////////////
            SQL = "CREATE TABLE IF NOT EXISTS FINANCE_YEAR"
                    + "(ID INTEGER PRIMARY KEY,"
                    + " YEAR INTEGER)";

            stmt.executeUpdate(SQL);
            ////////////////////////////////////////////////////////////////////
            System.out.println("Successfully connected to the database.");
        } catch (SQLException err) {

            System.out.println(err.getMessage());

        }
    } // End of the FinanceModel Constructor
    
    public ResultSet getFinanceMonths(int yearToObserve) {
        try {
            SQL = "SELECT MONTH FROM FINANCE WHERE YEAR = " + yearToObserve + ";";
            rs = stmt.executeQuery(SQL);
            return rs;

        } catch (SQLException err) {

            System.out.println(err.getMessage());
            return null;

        }
    } // End of the getFinanceYear method
    
    

}
