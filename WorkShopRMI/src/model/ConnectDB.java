/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;



/**
 *
 * @author Viet Long
 */
public class ConnectDB {

    public static Connection con = null;
    public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Employee;integratedSecurity=true;";
    public static String userDB = "sa";
    public static String passDB = "abcd";

    public static Connection getConnect() {
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(dbURL, userDB, passDB);
        } catch (Exception e) {
            System.out.println("Connect Fail");
            e.printStackTrace();
        }
        return con;
    }
    
    public static void main(String[] args) {
        Connection c = getConnect();
    }
}
    

