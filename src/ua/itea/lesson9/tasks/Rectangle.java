package ua.itea.lesson9.tasks;

public class Rectangle {
	private double perim;
	private double area;
	private String name = "Rectangle";
	private String color;
	
	public Rectangle(double side, String color) {
		reset(side);
		this.color = color;
	}
	
	public Rectangle(double sideA, double sideB, String color) {
		reset(sideA, sideB);
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
	
	public void reset(double side) {
		reset(side, side);
	}
	
	public void reset(double sideA, double sideB) {
		computePerimeter(sideA, sideB);
		computeArea(sideA, sideB);
	}
	
	private void computePerimeter(double sideA, double sideB) {
		perim = (sideA + sideB) * 2;
	}
	
	private void computeArea(double sideA, double sideB) {
		area = sideA * sideB;
	}
}
