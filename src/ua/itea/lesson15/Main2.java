package ua.itea.lesson15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

public class Main2 {
    public static void main(String[] args) {        
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            conn =
               DriverManager.getConnection("jdbc:mysql://s3.thehost.com.ua/itea2?" +
                                           "user=kate&password=Itea2020");

            System.out.println("Connection established");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
		try {
		    statement = conn.createStatement();
		    System.out.println("Statement created");

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		try {
		    resultSet = statement.executeQuery("SHOW DATABASES;");
		    while (resultSet.next()) {
		    	System.out.println(resultSet.getString("Database"));
		    }
		    System.out.println("***");
		    
		    resultSet = statement.executeQuery("SHOW TABLES;");
		    while (resultSet.next()) {
		    	System.out.println(resultSet.getString("Tables_in_itea2"));
		    }
		    System.out.println("***");
		    
		    resultSet = statement.executeQuery("DESCRIBE products;");
		    while (resultSet.next()) {
		    	System.out.println(resultSet.getString("Field"));
		    }
		    System.out.println("***");
		    
		    resultSet = statement.executeQuery("SELECT * FROM products;");
		    while (resultSet.next()) {
		    	System.out.println(String.format("%1s | %21s | %4s | %10s | %1s",
  					  resultSet.getString("id"),
  					  resultSet.getString("name"),
  					  resultSet.getString("price"),
  					  resultSet.getString("description"),
  					  resultSet.getString("category")));
		    }
		    System.out.println("***");
		    
//		    statement.execute("INSERT INTO `products` " +
//		    "(name, price, description, category) VALUES ('Nokia', 38, 'prod 5', 1);");
		    
//		    resultSet = statement.executeQuery("SELECT * FROM products;");
//		    while (resultSet.next()) {
//		    	System.out.println(String.format("%1s | %21s | %4s | %10s | %1s",
//  					  resultSet.getString("id"),
//  					  resultSet.getString("name"),
//  					  resultSet.getString("price"),
//  					  resultSet.getString("description"),
//  					  resultSet.getString("category")));
//		    }
//		    System.out.println("***");
		    
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
        
        
		System.out.println();
		System.out.println("--------------------------------------------");
		if (resultSet != null) {
			try {
				resultSet.close();
				System.out.println("ResultSet closed");
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}	
		}
		
		if (statement != null) {
			try {
				statement.close();
				System.out.println("Statement closed");
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}	
		}
		
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Connection closed");
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}	
		}
    }
    
}