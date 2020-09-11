package ua.itea.lesson10;

public class Car {
	public static String color;
	private static String mark = "Volvo";
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void getInfo() {
		System.out.println("Color: " + color
						   + "; Mark: " + mark);
	}
	
	public static String getMark() {
		return mark;
	}
}
