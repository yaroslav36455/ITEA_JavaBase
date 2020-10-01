package ua.itea.lesson15.tasks;

public class ColorRandomizer {
	private String[] colors = { "Black", "White", "Grey", "Red", "Green",
								"Blue", "Yellow", "Pink", "Brown", "Orange"};
	
	public String getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}
}
