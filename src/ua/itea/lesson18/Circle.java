package ua.itea.lesson18;

public class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
		calculatePerimeter();
	}
	
//	@Override
//	public void calculatePerimeter() {
//		perimeter = 2 * Math.PI * radius; 
//	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", perimeter=" + perimeter + "]";
	}

	@Override
	public void calculatePerimeter() {
		// TODO Auto-generated method stub
		
	}
}
