package ua.itea.lesson13.tasks.figure.factory;

import ua.itea.lesson13.tasks.figure.Figure;
import ua.itea.lesson13.tasks.ColorRandomizer;

public class FigureFactory {
	private ColorRandomizer colorRandomizer;
	
	public FigureFactory() {
		colorRandomizer = new ColorRandomizer();
	}
	
	public Figure create() {
		return new Figure(getRandomColor());
	}
	
	protected String getRandomColor() {
		return colorRandomizer.getRandomColor();
	}
}
