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
        
            host = "jdbc:derby://localhost:1527/StudentDatabase";
            username = "student";
            password = "password";
        
            con = DriverManager.getConnection(host, username, password);
            stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_READ_ONLY);
            
            //String sql = "CREATE DATABASE STUDENTS";
            //stmt.executeUpdate(sql);
            
            String sql = "TRUNCATE TABLE APP.STUDENTS";
            stmt.executeUpdate(sql);
            
            SQL = "select * from APP.STUDENTS";
            rs = stmt.executeQuery(SQL);
            
          
            
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
