package ua.itea.lesson8.tasks;

import java.util.Scanner;

public class FigureFactory {
	private BoundsDouble bounds;
	private RequesterDouble requester;
	
	public void initialize(Scanner scanner) {
		bounds = new BoundsDouble();
		bounds.exclude();
		requester = new RequesterDouble();
		requester.setBounds(bounds);
		requester.setScanner(scanner);
	}
	
	public Circle createCircle() {
		Circle circle = new Circle();
		
		System.out.println("Enter the radius");
		
		bounds.set(0, Double.MAX_VALUE);
		circle.set(requester.next("Radius"));
		
		return circle;
	}
	
	public Rectangle createRectangle() {
		Rectangle rectangle = new Rectangle();
		
		System.out.println("Enter the two sides");
		
		bounds.set(0, Double.MAX_VALUE);
		rectangle.set(requester.next("Side A"),
					  requester.next("Side B"));
		
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
		System.out.println("│ Computation Method Menu │");
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
		
		bounds.set(0, Double.MAX_VALUE);
		sideA = requester.next("Side A");
		sideB = requester.next("Side B");
		
		bounds.set(0, 180);
		angleAB.setDegree(requester.next("Angle AB"));
		
		triangle.set(sideA, sideB, angleAB);
	}
	
	private void setTriangleOneSideAndTwoAngles(Triangle triangle) {
		double sideA;
		Angle angleAB = new Angle();
		Angle angleAC = new Angle();
		
		System.out.println("Enter one side and two adjacent angles");
		
		bounds.set(0, Double.MAX_VALUE);
		sideA = requester.next("Side A");
		
		bounds.set(0, 180);
		angleAB.setDegree(requester.next("Angle AB"));

		bounds.set(0, 180 - angleAB.getDegree());
		angleAC.setDegree(requester.next("Angle AC"));
		
		triangle.set(sideA, angleAB, angleAC);
	}
}
