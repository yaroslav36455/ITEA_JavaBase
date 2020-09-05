package ua.itea.lesson8.tasks;

import java.util.Scanner;

public class FigureFactory {
	private Scanner scanner;
	
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public Circle createCircle() {
		Circle circle = new Circle();
		Bounds bounds = new Bounds();
		
		bounds.set(0, Double.MAX_VALUE);
		System.out.println("1 - Circle, enter the radius");
		circle.setRadius(getCorrectValue("Radius", bounds));
		return circle;
	}
	
	public Rectangle createRectangle() {
		Rectangle rectangle = new Rectangle();
		Bounds bounds = new Bounds();
		
		bounds.set(0, Double.MAX_VALUE);
		System.out.println("2 - Rectangle, enter the two sides");
		rectangle.set(getCorrectValue("Side 1", bounds),
					  getCorrectValue("Side 2", bounds));
		return rectangle;
	}
	
	public Triangle createTriangle() {
		Triangle triangle = new Triangle();
		Bounds bounds = new Bounds();
		
		bounds.set(0, 180);
		System.out.println("3 - Triangle, enter the two sides"
						   + " and the angle between them in degrees");
		triangle.set(getCorrectValue("Side 1", bounds),
					 getCorrectValue("Side 2", bounds),
					 getCorrectValue("Angle ", bounds));
		return triangle;
	}
	
	private double getCorrectValue(String label, Bounds bounds) {
		double value = 0.0;
		
		while (true) {
			System.out.print(label + ": ");
			if (scanner.hasNextDouble()) {
				value = scanner.nextDouble();
				if (bounds.isWithin(value)) {
					break;
				}
			} else {
				scanner.next();				
			}
			
			System.out.println("Invalid input, try again");
		}
		
		return value;
	}
}
