package ua.itea.lesson13.tasks.figure;

import ua.itea.lesson13.tasks.Angle;

public class Triangle extends Figure {
	
	public Triangle(double sideA, double sideB, Angle angleAB, String color) {
		super(color);
		reset(sideA, sideB, angleAB);
	}
	
	public Triangle(double sideA, Angle angleAB, Angle angleAC, String color) {
		super(color);
		reset(sideA, angleAB, angleAC);
	}
	
	@Override
	public String getName() {
		return "Triangle";
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
		setPerimeter(sideA + sideB + sideC);
	}
	
	private void computeArea(double sideA, double sideB, Angle angleAB) {
		setArea(sideA * sideB * Math.sin(angleAB.getRadians()) / 2);
	}
	
	private void computePerimeter(double sideA, Angle angleAB, Angle angleAC) {
		double heightA = sideA / (angleAB.ctg() + angleAC.ctg());
		double sideAPartOne = heightA / angleAB.tan();
		double sideAPartTwo = heightA / angleAC.tan();
		double sideB = Math.sqrt(sideAPartOne * sideAPartOne + heightA * heightA);
		double sideC = Math.sqrt(sideAPartTwo * sideAPartTwo + heightA * heightA);
		
		setPerimeter(sideA + sideB + sideC);
	}
	
	private void computeArea(double sideA, Angle angleAB, Angle angleAC) {
		setArea(sideA * sideA / (angleAB.ctg() + angleAC.ctg()) / 2);
	}
}
