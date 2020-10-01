package ua.itea.lesson15.tasks.shape.factory;

import ua.itea.lesson15.tasks.ColorRandomizer;
import ua.itea.lesson15.tasks.shape.Shape;

public class ShapeFactory {
	private ColorRandomizer colorRandomizer;
	
	public ShapeFactory() {
		colorRandomizer = new ColorRandomizer();
	}
	
	public Shape create() {
		throw new RuntimeException("Unimplemented method 'create()'"
				   				   + " in class ShapeFactory");
	}
	
	protected String getRandomColor() {
		return colorRandomizer.getRandomColor();
	}
}
