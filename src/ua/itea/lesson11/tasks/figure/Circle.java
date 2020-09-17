package ua.itea.lesson11.tasks.figure;

public class Circle extends Figure {
	
	public Circle(double radius, String color) {
		super(color);
		reset(radius);
	}
	
	@Override
	public String getName() {
		return "Circle";
	}
	
	public void reset(double radius) {
		computePerimeter(radius);
		computeArea(radius);
	}
	
	private void computePerimeter(double radius) {
		setPerimeter(radius * 2.0 * Math.PI);
	}
	
	private void computeArea(double radius) {
		setArea(radius * radius * Math.PI);
	}
}
