package ua.itea.lesson15.tasks;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.sql.Statement;
import java.util.Arrays;

import ua.itea.lesson15.tasks.shape.Shape;

public class ShapeDatabase extends ShapeContainer {
	private Connection connection = null;
	private Statement statement = null;
	private String databaseName = "shapes";
	private String tableName = "shapes";
	
	public ShapeDatabase() throws SQLException {
		Console console = System.console();
		boolean isInvalidAuthorization = true;
		
		do {
			try {
				String host = console.readLine("host=");
				String user = console.readLine("user=");
				char[] password = console.readPassword("password=");
				
				String connStr = "jdbc:mysql://" + host + "/"
	       	         			 + "?user=" + user
	       	         			 + "&password=" + String.valueOf(password);
		
				/* the connStr is not cleared! */
				Arrays.fill(password, '\0');
				connection = DriverManager.getConnection(connStr);
				
				isInvalidAuthorization = false;
				
			} catch (SQLInvalidAuthorizationSpecException ex) {
				System.out.println(ex.getMessage());
			}
			
		} while(isInvalidAuthorization);
		
		statement = connection.createStatement();
		
		supplyDatabase();		
		supplyTable();
	}
	
	private void supplyDatabase() throws SQLException {
		ResultSet resultSet = statement.executeQuery("SHOW DATABASES;");
		boolean databaseFound = false;
		
		while (resultSet.next()) {
			if (resultSet.getString("Database").equals(databaseName)) {
				databaseFound = true;
			}
		}
		
		if (!databaseFound) {
			statement.execute("CREATE DATABASE `" + databaseName + "`;");
		}
		
		resultSet.close();
	}
	
	private void supplyTable() throws SQLException {
		ResultSet resultSet = null;
		boolean tableFound = false;
		
		statement.execute("USE `" + databaseName + "`;");
		resultSet = statement.executeQuery("SHOW TABLES;");
		
		while (resultSet.next()) {
			if (resultSet.getString("Tables_in_" + databaseName).equals(tableName)) {
				tableFound = true;
			}
		}
		
		if (!tableFound) {
			statement.execute("CREATE TABLE `" + tableName + "` "
							  + "(id TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT, "
							  + "name VARCHAR(9) NOT NULL, " 
							  + "perimeter DOUBLE UNSIGNED NOT NULL, " 
							  + "area DOUBLE UNSIGNED NOT NULL, "
							  + "color VARCHAR(6) NOT NULL);");
		}
		
		resultSet.close();
	}
	
	@Override
	public int size() throws SQLException {
		ResultSet resultSet = null;
		int size = 0;
		
		statement.execute("USE `" + databaseName + "`;");
		resultSet = statement.executeQuery("SELECT COUNT(*) FROM `" + tableName + "`;");
		
		if (resultSet.next()) {
			size = resultSet.getInt("COUNT(*)");	
		}
		
		resultSet.close();
		
		return size;
	}
	
	@Override
	public void add(Shape shape, Shape ...shapes) throws SQLException {
		StringBuffer sb = new StringBuffer();
		
		addToBuffer(sb, shape);
		addToBuffer(sb, shapes);
		
		statement.execute("USE `" + databaseName + "`;");
		statement.execute(sb.toString());
	}
	
	private void addToBuffer(StringBuffer sb, Shape[] shapes) {
		for (Shape sh : shapes) {
			addToBuffer(sb, sh);
		}
	}
	
	private void addToBuffer(StringBuffer sb, Shape shape) {
		sb.append("INSERT INTO `" + tableName + "` "
				  + "(name, perimeter, area, color) VALUES ('"
				  + shape.getName() + "', " + shape.getPerimeter() + ", "
			      + shape.getArea() + ", '" + shape.getColor() + "');");
	}
	
	@Override
	public void add(ShapeContainer container, ShapeContainer ...containers) throws SQLException {
		StringBuffer sb = new StringBuffer();
		
		addToBuffer(sb, container);
		addToBuffer(sb, containers);
		
		statement.execute("USE `" + databaseName + "`;");
		statement.execute(sb.toString());
	}
	
	private void addToBuffer(StringBuffer sb, ShapeContainer[] containers) {
		for (ShapeContainer shCont : containers) {
			addToBuffer(sb, shCont);
		}
	}
	
	private void addToBuffer(StringBuffer sb, ShapeContainer container) {
		addToBuffer(sb, container.getShapes());
	}
	
	@Override
	public String toString() {
		try {
			if(isEmpty()) {
				return "No shapes";
			} else {
				ResultSet resultSet = null;
				StringBuffer result = null;

				statement.execute("USE `" + databaseName + "`;");
				resultSet = statement.executeQuery("SELECT * FROM `" + tableName + "`;");
				result = new StringBuffer();

				result.append("┏━┯━━━━━━━━━┯━━━━━━━━━┯━━━━━━━━━┯━━━━━━┓\n");
				result.append("┃№│Shape    │Perimeter│Area     │Color ┃\n");
				result.append("┠─┼─────────┼─────────┼─────────┼──────┨\n");
				
				while(resultSet.next()) {
					result.append(String.format("┃%d│%-9s│%.3e│%.3e│%-6s┃%n",
												resultSet.getInt("id"),
												resultSet.getString("name"),
												resultSet.getDouble("perimeter"),
												resultSet.getDouble("area"),
												resultSet.getString("color")));
				}

				result.append("┗━┷━━━━━━━━━┷━━━━━━━━━┷━━━━━━━━━┷━━━━━━┛");
				
				if (resultSet != null) {
					resultSet.close();
				}
				
				return result.toString();
			}
		} catch (SQLException ex) {
			return ex.getMessage();
		}
	}
	
	public void close() throws SQLException {
		if (statement != null) {
			statement.close();
		}
		
		if (connection != null) {
			connection.close();
		}
	}
}
