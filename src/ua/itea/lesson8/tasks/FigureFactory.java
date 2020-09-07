package ua.itea.lesson8.tasks;

import java.util.Scanner;

public class FigureFactory {
	private RequesterDouble requesterLength = new RequesterDouble();
	private RequesterDouble requesterDegree = new RequesterDouble();
	
	public void initialize(Scanner scanner) {
		BoundsDouble boundsLength = new BoundsDouble();
		BoundsDouble boundsDegree = new BoundsDouble();
		
		boundsLength.set(0, Double.MAX_VALUE);
		boundsLength.exclude();
		requesterLength.setScanner(scanner);
		requesterLength.setBounds(boundsLength);

		boundsDegree.set(0, 180);
		boundsDegree.exclude();
		requesterDegree.setScanner(scanner);
		requesterDegree.setBounds(boundsDegree);
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
