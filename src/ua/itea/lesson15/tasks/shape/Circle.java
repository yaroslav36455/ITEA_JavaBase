package ua.itea.lesson15.tasks.shape;

public class Circle extends Shape {
	
	public Circle(Circle other) {
		super(other);
	}
	
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
