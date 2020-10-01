package ua.itea.lesson15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement statement = null;
	    ResultSet resultSet = null;
		
		try {
		    conn = DriverManager.getConnection("jdbc:mysql://localhost/ALKOTEST?" +
		                                   	   "user=root&password=");

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
		    resultSet = statement.executeQuery("SELECT * FROM `drinks`;");
		    while (resultSet.next()) {
		    	System.out.println(String.format("%2s | %15s | %2s | %1s | %6s",
		    					  resultSet.getString("d_id"),
		    					  resultSet.getString("d_name"),
		    					  resultSet.getString("d_degree"),
		    					  resultSet.getString("d_category"),
		    					  resultSet.getString("d_volume")));
		    }
		    
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		
		try {
			statement.execute("INSERT INTO `drinks` (d_name, d_degree, d_category, d_volume) VALUES ('some drink', 100, 4, 23.12);");
			
			resultSet = statement.executeQuery("SELECT * FROM `drinks`;");
		    while (resultSet.next()) {
		    	System.out.println(String.format("%2s | %15s | %2s | %1s | %6s",
		    					  resultSet.getString("d_id"),
		    					  resultSet.getString("d_name"),
		    					  resultSet.getString("d_degree"),
		    					  resultSet.getString("d_category"),
		    					  resultSet.getString("d_volume")));
		    }
		    
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
