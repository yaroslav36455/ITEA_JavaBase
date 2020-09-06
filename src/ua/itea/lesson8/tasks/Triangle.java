package ua.itea.lesson8.tasks;

public class Triangle {
	private double perim = 0.0;
	private double area  = 0.0;
	private String name  = "Triangle";
	private String color = "<none>";
	
	public void printInfo() {
		System.out.printf("Figure: %s; Perimeter: %.3e; Area: %.3e; Color: %s\n",
						  name, perim, area, color);
	}
	
	public void set(double sideA, double sideB, double angle) {
		angle = angle * Math.PI / 180;
		computePerimeter(sideA, sideB, angle);
		computeArea(sideA, sideB, angle);
		updateColor();
	}
	
	private void computePerimeter(double sideA, double sideB, double angle) {
		double sideC = Math.sqrt(sideA * sideA + sideB * sideB
								 - 2 * sideA * sideB * Math.cos(angle));
		perim = sideA + sideB + sideC;
	}
	
	private void computeArea(double sideA, double sideB, double angle) {
		area = sideA * sideB * Math.sin(angle) / 2;
	}
	
	private void updateColor() {
		color = (area > 5.0) ? "White" : "Black";
	}
}
