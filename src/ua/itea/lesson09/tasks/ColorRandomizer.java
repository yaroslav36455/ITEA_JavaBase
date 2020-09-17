package ua.itea.lesson09.tasks;

public class ColorRandomizer {
	private String[] colors = { "Black", "White", "Grey", "Red", "Green",
								"Blue", "Yellow", "Pink", "Brown", "Orange"};
	
	String getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}
}
