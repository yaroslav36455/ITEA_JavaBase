package ua.itea.lesson18;

public abstract class Shape {
	protected double perimeter;
	
	public Shape() {
		System.out.println("Shape constructor");
	}
	
	public Shape(double perimeter) {
		this.perimeter = perimeter;
	}
	
	public abstract void calculatePerimeter();
}
