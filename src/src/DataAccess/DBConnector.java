package DataAccess;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    public static final String URL = "jdbc:mysql://localhost/myproject";
    public static final String USER = "root";
    public static final String PASS = "";
    private static final DBConnector instance = new DBConnector();
    //private constructor to avoid client applications to use constructor
    public static DBConnector getInstance(){
        return instance;
    }
    private DBConnector() {

    }
    /**
     * Get a connection to database
     *
     * @return Connection object
     */
    public static Connection getConnection() {
        try {
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //return DriverManager.getConnection(URL, USER, PASS);
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("success");
            return conn;
        } catch (Exception ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
     /**
         * Test Connection
         */


}
