package ua.itea.lesson12.tasks.figure;

public class Rectangle extends Figure {
	
	public Rectangle(double side, String color) {
		super(color);
		reset(side);
	}
	
	public Rectangle(double sideA, double sideB, String color) {
		super(color);
		reset(sideA, sideB);
	}
	
	@Override
	public String getName() {
		return "Rectangle";
	}
	
	public void reset(double side) {
		reset(side, side);
	}
	
	public void reset(double sideA, double sideB) {
		computePerimeter(sideA, sideB);
		computeArea(sideA, sideB);
	}
	
	private void computePerimeter(double sideA, double sideB) {
		setPerimeter((sideA + sideB) * 2);
	}
	
	private void computeArea(double sideA, double sideB) {
		setArea(sideA * sideB);
	}
}
