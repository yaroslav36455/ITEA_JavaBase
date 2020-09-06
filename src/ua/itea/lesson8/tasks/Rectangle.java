package ua.itea.lesson8.tasks;

public class Rectangle {
	private double perim = 0.0;
	private double area  = 0.0;
	private String name  = "Rectangle";
	private String color = "<none>";
	
	public void printInfo() {
		System.out.printf("Figure: %s; Perimeter: %.3e; Area: %.3e; Color: %s\n",
						  name, perim, area, color);
	}
	
	public void set(double side) {
		set(side, side);
	}
	
	public void set(double sideA, double sideB) {
		computePerimeter(sideA, sideB);
		computeArea(sideA, sideB);
		updateColor();
	}
	
	private void computePerimeter(double sideA, double sideB) {
		perim = (sideA + sideB) * 2;
	}
	
	private void computeArea(double sideA, double sideB) {
		area = sideA * sideB;
	}
	
	private void updateColor() {
		color = (area > 5.0) ? "White" : "Black";
	}
}
