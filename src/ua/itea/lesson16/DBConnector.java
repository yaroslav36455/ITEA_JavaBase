package ua.itea.lesson16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	public Connection getConnection() {
		Connection conn = null;
        try {
            conn =
               DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                   	   					   "user=root&password=");

            System.out.println("Connection established");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return conn;
	}
}
