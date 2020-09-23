package ua.itea.lesson13.tasks.shape.factory;

import ua.itea.lesson13.tasks.ColorRandomizer;
import ua.itea.lesson13.tasks.shape.Shape;

public class ShapeFactory {
	private ColorRandomizer colorRandomizer;
	
	public ShapeFactory() {
		colorRandomizer = new ColorRandomizer();
	}
	
	public Shape create() {
		return new Shape(getRandomColor());
	}
	
	protected String getRandomColor() {
		return colorRandomizer.getRandomColor();
	}
}
