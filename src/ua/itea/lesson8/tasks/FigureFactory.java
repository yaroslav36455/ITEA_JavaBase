package ua.itea.lesson8.tasks;

import java.util.Scanner;

public class FigureFactory {
	private RequesterDouble requesterLength = new RequesterDouble();
	private RequesterDouble requesterDegree = new RequesterDouble();
	
	public void initialize(Scanner scanner) {
		requesterLength.setScanner(scanner);
		requesterLength.setBounds(Double.MIN_VALUE, Double.MAX_VALUE);
		
		requesterDegree.setScanner(scanner);
		requesterDegree.setBounds(Double.MIN_VALUE, 180 - Double.MIN_VALUE);
	}
	
	public Circle createCircle() {
		Circle circle = new Circle();
		
		System.out.println(", enter the radius");
		circle.set(requesterLength.next("Radius"));
		return circle;
	}
	
	public Rectangle createRectangle() {
		Rectangle rectangle = new Rectangle();
		
		System.out.println(", enter the two sides");
		rectangle.set(requesterLength.next("Side 1"),
					  requesterLength.next("Side 2"));
		return rectangle;
	}
	
	public Triangle createTriangle() {
		Triangle triangle = new Triangle();
		
		System.out.println(", enter the two sides"
				   		   + " and the angle between them in degrees");
		triangle.set(requesterLength.next("Side 1"),
					 requesterLength.next("Side 2"),
					 requesterDegree.next("Angle "));
		return triangle;
	}
}
