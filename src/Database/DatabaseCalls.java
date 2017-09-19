/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexander
 */
public class DatabaseCalls {

    static DataInputStream dataInputStream;
    static DataOutputStream dataOutputStream;

    private String JDBC_DRIVER;
    private String DB_URL;
    //Database credentials
    private String USER;
    private String PASS;
    private Connection conn;
    private String query;

    public DatabaseCalls() {
        JDBC_DRIVER = "com.mysql.jdbc.Driver";
        DB_URL = "jdbc:mysql://localhost:3306/slotmachinedb?zeroDateTimeBehavior=convertToNull";
        USER = "root";
        PASS = "root";
        conn = null;
        openConnection();
    }

    public void openConnection() {
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //Open a connection
            System.out.print("Connecting to a selected database... ");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            //Handle errors for JDBC
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseCalls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
