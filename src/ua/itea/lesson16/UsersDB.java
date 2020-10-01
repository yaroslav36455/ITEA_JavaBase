package ua.itea.lesson16;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersDB {
	private final static String INSERT = "INSERT INTO `users` (login, password) VALUES ('%s', '%s')";
	
	public void addUser(Connection conn, String login, String password) {
		Statement statement = null;
		try {
			statement = conn.createStatement();
			statement.execute(String.format(INSERT, login, password));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
