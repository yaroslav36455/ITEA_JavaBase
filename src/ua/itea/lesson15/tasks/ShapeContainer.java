package ua.itea.lesson15.tasks;

import java.sql.SQLException;

import ua.itea.lesson15.tasks.shape.Shape;

public class ShapeContainer {
	
	public int size() throws SQLException {
		throw new RuntimeException("Unimplemented method 'size()'"
				   				   + " in class ShapeContainer");
	}
	
	public void add(Shape shape, Shape ...shapes) throws SQLException {
		throw new RuntimeException("Unimplemented method 'add(Shape shape, Shape ...shapes)'"
				                   + " in class ShapeContainer");
	}
	
	public void add(ShapeContainer container, ShapeContainer ...containers) throws SQLException {
		throw new RuntimeException("Unimplemented method 'add(ShapeContainer container, ShapeContainer ...containers)'"
				   				   + " in class ShapeContainer");
	}
	
	public boolean isEmpty() throws SQLException {
		return size() == 0;
	}
	
	public Shape[] getShapes() {
		throw new RuntimeException("Unimplemented method 'getShapes()'"
				   				   + " in class ShapeContainer");
	}
}
