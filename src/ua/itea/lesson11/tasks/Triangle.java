package ua.itea.lesson11.tasks;

public class Triangle {
	private double perim;
	private double area;
	private String name = "Triangle";
	private String color;
	
	public Triangle(double sideA, double sideB, Angle angleAB, String color) {
		reset(sideA, sideB, angleAB);
		this.color = color;
	}
	
	public Triangle(double sideA, Angle angleAB, Angle angleAC, String color) {
		reset(sideA, angleAB, angleAC);
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
	
	public void reset(double sideA, double sideB, Angle angleAB) {
		computePerimeter(sideA, sideB, angleAB);
		computeArea(sideA, sideB, angleAB);
	}
	
	public void reset(double sideA, Angle angleAB, Angle angleAC) {
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
