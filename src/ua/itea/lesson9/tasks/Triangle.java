package ua.itea.lesson9.tasks;

public class Triangle {
	private double perim;
	private double area;
	private String name = "Triangle";
	private String color;
	
	public Triangle(String color) {
		this.color = color;
	}
	
	public void printInfo() {
		System.out.printf("Figure: %-9s; Perimeter: %.3e; Area: %.3e; Color: %s\n",
						  name, perim, area, color);
	}
	
	public void set(double sideA, double sideB, Angle angleAB) {
		computePerimeter(sideA, sideB, angleAB);
		computeArea(sideA, sideB, angleAB);
	}
	
	public void set(double sideA, Angle angleAB, Angle angleAC) {
		computePerimeter(sideA, angleAB, angleAC);
		computeArea(sideA, angleAB, angleAC);
	}
	
	private void computePerimeter(double sideA, double sideB, Angle angleAB) {
		double sideC = Math.sqrt(sideA * sideA + sideB * sideB
								 - 2 * sideA * sideB * Math.cos(angleAB.getRadians()));
		perim = sideA + sideB + sideC;
	}
	
	private void computeArea(double sideA, double sideB, Angle angleAB) {
		area = sideA * sideB * Math.sin(angleAB.getRadians()) / 2;
	}
	
	private void computePerimeter(double sideA, Angle angleAB, Angle angleAC) {
		double heightA = sideA / (angleAB.ctg() + angleAC.ctg());
		double sideAPartOne = heightA / angleAB.tan();
		double sideAPartTwo = heightA / angleAC.tan();
		double sideB = Math.sqrt(sideAPartOne * sideAPartOne + heightA * heightA);
		double sideC = Math.sqrt(sideAPartTwo * sideAPartTwo + heightA * heightA);
		
		perim = sideA + sideB + sideC;
	}
	
	private void computeArea(double sideA, Angle angleAB, Angle angleAC) {
		area = sideA * sideA / (angleAB.ctg() + angleAC.ctg()) / 2;
	}
}
