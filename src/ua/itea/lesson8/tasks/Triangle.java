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
	
	public void set(double sideA, double sideB, Angle angleAB) {
		computePerimeter(sideA, sideB, angleAB);
		computeArea(sideA, sideB, angleAB);
		updateColor();
	}
	
	private void computePerimeter(double sideA, double sideB, Angle angleAB) {
		double sideC = Math.sqrt(sideA * sideA + sideB * sideB
								 - 2 * sideA * sideB * Math.cos(angleAB.getRadians()));
		perim = sideA + sideB + sideC;
	}
	
	private void computeArea(double sideA, double sideB, Angle angleAB) {
		area = sideA * sideB * Math.sin(angleAB.getRadians()) / 2;
	}
	
	private void updateColor() {
		color = (area > 5.0) ? "White" : "Black";
	}
}
