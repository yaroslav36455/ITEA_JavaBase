package ua.itea.lesson8.tasks;

public class Circle {
	private double perim = 0.0;
	private double area  = 0.0;
	private String name  = "Circle";
	private String color = "<none>";

	public void printInfo() {
		System.out.printf("Figure: %s; Perimeter: %.3f; Area: %.3f; Color: %s\n",
						  name, perim, area, color);
	}
	
	public void setDiameter(double diameter) {
		setRadius(diameter / 2.0);
	}
	
	public void setRadius(double radius) {
		computePerimeter(radius);
		computeArea(radius);
		updateColor();
	}
	
	private void computePerimeter(double radius) {
		perim = radius * 2.0 * Math.PI;
	}
	
	private void computeArea(double radius) {
		area = radius * radius * Math.PI;
	}
	
	private void updateColor() {
		color = (area > 5.0) ? "White" : "Black";
	}
}
