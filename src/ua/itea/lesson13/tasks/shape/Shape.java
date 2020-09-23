package ua.itea.lesson13.tasks.shape;

public class Shape {
	private double perim;
	private double area;
	private String color;
	
	public Shape(Shape other) {
		this.perim = other.perim;
		this.area = other.area;
		this.color = other.color;
	}
	
	public Shape(String color) {
		this.color = color;
	}
	
	public String getName() {
		return "Shape";
	}
	
	public double getPerimeter() {
		return perim;
	}
	
	public double getArea() {
		return area;
	}
	
	public String getColor() {
		return color;
	}
	
	protected void setPerimeter(double perim) {
		this.perim = perim;
	}
	
	protected void setArea(double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Shape [getName()=" + getName() + ", getPerimeter()=" + getPerimeter()
				+ ", getArea()=" + getArea() + ", getColor()=" + getColor() + "]";
	}
}
