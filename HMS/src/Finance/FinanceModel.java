/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

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
            SQL = "CREATE TABLE IF NOT EXISTS FINANCE_MONTHS"
                    + "(ID INTEGER PRIMARY KEY,"
                    + " YEAR INTEGER,"
                    + " MONTH TEXT,"
                    + " REVENUE REAL,"
                    + " EXPENSES REAL,"
                    + " NET_PROFIT REAL)";

            stmt.executeUpdate(SQL);
            ////////////////////////////////////////////////////////////////////
            SQL = "CREATE TABLE IF NOT EXISTS FINANCE_YEARS"
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
            SQL = "SELECT * FROM FINANCE_MONTHS WHERE YEAR = " + yearToObserve;
            rs = stmt.executeQuery(SQL);
            return rs;

        } catch (SQLException err) {

            System.out.println(err.getMessage());
            return null;

        }
    } // End of the getFinanceYear method

    public void updateFinanceValue(String columnName, int userId, Object value, int row, int column) {
        try {
            if (column != 0) {
                stmt.executeUpdate("UPDATE FINANCE_MONTHS SET " + columnName
                        + " = '" + value + "' WHERE ID = " + userId);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    } // End of the updateUserValue method

    public void appendFinanceYearComboBox(JComboBox financeYear) {
        int maxId = -1;
        try {
            SQL = "SELECT MAX(ID) AS ID FROM FINANCE_YEARS";
            ResultSet rs = stmt.executeQuery(SQL);
            maxId = rs.getInt(1);
            stmt.close();

            stmt = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            SQL = "SELECT YEAR from FINANCE_YEARS WHERE ID = " + maxId;
            rs = stmt.executeQuery(SQL);

            Object newestYear = rs.getInt(1);
            financeYear.addItem(newestYear);

        } catch (SQLException err) {
            System.out.println(err.getMessage());

        }
    }
    
    public void deleteFinanceYearFromComboBox(JComboBox financeYearComboBox, int yearToDelete) {
        int totalNumberOfItems = financeYearComboBox.getItemCount();
        for(int index = 0; index < totalNumberOfItems; index++) {
            int yearInComboBox = Integer.parseInt(financeYearComboBox.getItemAt(index).toString());
            if(yearInComboBox == yearToDelete) {
                Object itemToDelete = financeYearComboBox.getItemAt(index);
                financeYearComboBox.removeItem(itemToDelete);
            }
        }
    } // End of the deleteFinanceYearFromComboBox

    public void setFinanceYearComboBox(JComboBox financeYear) {
        ComboBoxModel comboBoxModel = financeYear.getModel();
        try {
            SQL = "SELECT * from FINANCE_YEARS";
            rs = stmt.executeQuery(SQL);
            int index = 2;
            while (rs.next()) {
                String newYear = rs.getString(index);
                financeYear.addItem(rs.getString(index));
                //comboBoxModel.setSelectedItem(rs.getString(index));
                //index++;
            }
        } catch (SQLException err) {
            err.getMessage();
        }
        financeYear.setModel(comboBoxModel);
    } // End of the the setFinanceYearComboBox

    public void deleteYearAndMonths(int yearToDelete) {
        stmt = null;
        try {
            stmt = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            SQL = "DELETE from FINANCE_YEARS WHERE YEAR = " + yearToDelete;
            stmt.executeUpdate(SQL);
            //stmt.close();
            
            SQL = "DELETE from FINANCE_MONTHS WHERE YEAR = " + yearToDelete;
            stmt.executeUpdate(SQL);
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

}
