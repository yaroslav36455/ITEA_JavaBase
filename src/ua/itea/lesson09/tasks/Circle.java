package ua.itea.lesson09.tasks;

public class Circle {
	private double perim;
	private double area;
	private String name = "Circle";
	private String color;
	
	public Circle(double radius, String color) {
		reset(radius);
		this.color = color; 
	}
	
	String getName() {
		return name;
	}
	
	double getPerimeter() {
		return perim;
	}
	
	double getArea() {
		return area;
	}
	
	String getColor() {
		return color;
	}
	
	public void reset(double radius) {
		computePerimeter(radius);
		computeArea(radius);
	}
	
	private void computePerimeter(double radius) {
		perim = radius * 2.0 * Math.PI;
	}
	
	private void computeArea(double radius) {
		area = radius * radius * Math.PI;
	}
}
