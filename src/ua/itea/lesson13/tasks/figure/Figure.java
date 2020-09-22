package ua.itea.lesson13.tasks.figure;

public class Figure {
	private double perim;
	private double area;
	private String color;
	
	public Figure(String color) {
		this.color = color;
	}
	
	public String getName() {
		return "Figure";
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
		return "Figure [getName()=" + getName() + ", getPerimeter()=" + getPerimeter()
				+ ", getArea()=" + getArea() + ", getColor()=" + getColor() + "]";
	}
}
