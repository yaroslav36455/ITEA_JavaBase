package ua.itea.lesson8.tasks;

import java.util.Scanner;

public class FigureFactory {
	private RequesterDouble requesterLength;
	private RequesterDouble requesterDegree;
	
	public void initialize(Scanner scanner) {
		requesterLength = createRequester(scanner, 0, Double.MAX_VALUE);
		requesterDegree = createRequester(scanner, 0, 180);
	}
	
	private RequesterDouble createRequester(Scanner scanner,
											double boundFirst,
											double boundSecond) {
		RequesterDouble requester = new RequesterDouble();
		BoundsDouble bounds = new BoundsDouble();
		
		bounds.set(boundFirst, boundSecond);
		bounds.exclude();
		requester.setBounds(bounds);
		requester.setScanner(scanner);
		
		return requester;
	}
	
	public Circle createCircle() {
		Circle circle = new Circle();
		
		System.out.println("Enter the radius");
		circle.set(requesterLength.next("Radius"));
		return circle;
	}
	
	public Rectangle createRectangle() {
		Rectangle rectangle = new Rectangle();
		
		System.out.println("Enter the two sides");
		rectangle.set(requesterLength.next("Side 1"),
					  requesterLength.next("Side 2"));
		return rectangle;
	}
	
	public Triangle createTriangle() {
		Triangle triangle = new Triangle();
		
		System.out.println("Enter the two sides"
				   		   + " and the angle between them in degrees");
		triangle.set(requesterLength.next("Side 1"),
					 requesterLength.next("Side 2"),
					 requesterDegree.next("Angle "));
		return triangle;
	}
}
