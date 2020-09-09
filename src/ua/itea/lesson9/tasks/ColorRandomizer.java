package ua.itea.lesson9.tasks;

public class ColorRandomizer {
	String[] colors = { "Black", "White", "Grey", "Red", "Green",
						"Blue", "Yellow", "Pink", "Brown", "Orange"};
	
	String getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}
}
