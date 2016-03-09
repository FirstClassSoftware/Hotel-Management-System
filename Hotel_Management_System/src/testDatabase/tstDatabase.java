/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Whelan
 */
public class tstDatabase {
    
    private String host;
    private String username;
    private String password;
    private Connection con;
    private Statement stmt;
    private String SQL;
    private ResultSet rs;
    private String Database;
    private String table;
    
    public tstDatabase() {
        
        try {
        
            host = "jdbc:sqlite:filename.db";
            username = "student";
            password = "password";
        
            con = DriverManager.getConnection(host, username, password);
            stmt = con.createStatement( ResultSet.TYPE_FORWARD_ONLY, 
                    ResultSet.CONCUR_READ_ONLY);
            
            //SQL = "CREATE DATABASE APP";
            //stmt.executeUpdate(SQL);
            
            SQL = "CREATE TABLE RESERVATIONS" +
                    "(ID INT PRIMARY KEY     NOT NULL"
                    + "";
            stmt.executeUpdate(SQL);
                
            
            //SQL = "select * from APP.STUDENTS";
            //rs = stmt.executeQuery(SQL);
            
          
            
           // String SQL = "DELETE TABLE ?";
             
           // PreparedStatement st = con.prepareStatement(SQL);
            //st.setString(1, table);
            //st.executeUpdate(); 
        }
                    
        
        catch(SQLException err) {
            System.out.println(err.getMessage());
        }
        
    }
    
}
