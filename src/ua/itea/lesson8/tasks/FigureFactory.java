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
	
	public Triangle createTriangle(Scanner scanner) {
		Triangle triangle = new Triangle();
		RequesterInteger requester = new RequesterInteger();
		BoundsInteger menuItems = new BoundsInteger();

		menuItems.set(1, 2);
		menuItems.include();
		requester.setBounds(menuItems);
		requester.setScanner(scanner);
		
		System.out.println("┌─────────────────────────┐");
		System.out.println("│     Triangle Menu       │");
		System.out.println("│1-Two sides and angle    │");
		System.out.println("│2-One side and two angles│");
		System.out.println("└─────────────────────────┘");
		
		switch (requester.next("Select computation method")) {
		case 1:
			setTriangleTwoSidesAndAngle(triangle);
			break;
			
		case 2:
			setTriangleOneSideAndTwoAngles(triangle);
			break;
			
		default:
			/* never fall into */
			break;
		}
		
		return triangle;
	}
	
	private void setTriangleTwoSidesAndAngle(Triangle triangle) {
		double sideA;
		double sideB;
		Angle angleAB = new Angle();
		
		System.out.println("Enter the two sides"
				   		   + " and the angle between them in degrees");
		sideA = requesterLength.next("Side 1");
		sideB = requesterLength.next("Side 2");
		angleAB.setDegree(requesterDegree.next("Angle "));
		triangle.set(sideA, sideB, angleAB);
	}
	
	private void setTriangleOneSideAndTwoAngles(Triangle triangle) {
		double sideA;
		Angle angleAB = new Angle();
		Angle angleAC = new Angle();
		
		System.out.println("Enter one side and two adjacent angles");
		sideA = requesterLength.next("Side   ");
		angleAB.setDegree(requesterDegree.next("Angle 1"));
		angleAC.setDegree(requesterDegree.next("Angle 2"));
		triangle.set(sideA, angleAB, angleAC);
	}
}
