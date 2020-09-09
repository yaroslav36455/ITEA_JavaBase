package ua.itea.lesson9.tasks;

public class Circle {
	private double perim;
	private double area;
	private String name = "Circle";
	private String color;
	
	public Circle(String color) {
		this.color = color; 
	}

	public void printInfo() {
		System.out.printf("Figure: %-9s; Perimeter: %.3e; Area: %.3e; Color: %s\n",
						  name, perim, area, color);
	}
	
	public void set(double radius) {
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
