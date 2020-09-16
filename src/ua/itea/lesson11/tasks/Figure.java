package ua.itea.lesson11.tasks;

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
}
