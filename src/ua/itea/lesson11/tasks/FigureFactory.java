package ua.itea.lesson11.tasks;

import java.util.Scanner;

import ua.itea.lesson11.tasks.figure.Circle;
import ua.itea.lesson11.tasks.figure.Rectangle;
import ua.itea.lesson11.tasks.figure.Triangle;

public class FigureFactory {
	private BoundsDouble bounds;
	private RequesterDouble requester;
	private ColorRandomizer colorRandomizer;
	
	public FigureFactory(Scanner scanner) {
		bounds = new BoundsDouble();
		bounds.exclude();
		
		requester = new RequesterDouble(scanner, bounds);
		
		colorRandomizer = new ColorRandomizer();
	}
	
	public Circle createCircle() {
		System.out.println("Enter the radius");
		
		bounds.set(0, Double.MAX_VALUE);
		return new Circle(requester.next("Radius"),
					      colorRandomizer.getRandomColor());
	}
	
	public Rectangle createRectangle() {
		System.out.println("Enter the two sides");
		
		bounds.set(0, Double.MAX_VALUE);
		return new Rectangle(requester.next("Side A"),
							 requester.next("Side B"),
							 colorRandomizer.getRandomColor());
	}
	
	public Triangle createTriangle(Scanner scanner) {
		Triangle triangle = null;
		RequesterInteger requester;
		BoundsInteger menuItems = new BoundsInteger();

		menuItems.set(1, 2);
		menuItems.include();
		requester = new RequesterInteger(scanner, menuItems);
		
		System.out.println("┌─────────────────────────┐");
		System.out.println("│ Computation Method Menu │");
		System.out.println("│1-Two sides and angle    │");
		System.out.println("│2-One side and two angles│");
		System.out.println("└─────────────────────────┘");
		
		switch (requester.next("Select computation method")) {
		case 1:
			triangle = createTriangleTwoSidesAndAngle();
			break;
			
		case 2:
			triangle = createTriangleOneSideAndTwoAngles();
			break;
			
		default:
			/* never fall into */
			break;
		}
		
		return triangle;
	}
	
	private Triangle createTriangleTwoSidesAndAngle() {
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
		
		return new Triangle(sideA, sideB, angleAB,
							colorRandomizer.getRandomColor());
	}
	
	private Triangle createTriangleOneSideAndTwoAngles() {
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
		
		return new Triangle(sideA, angleAB, angleAC,
							colorRandomizer.getRandomColor());
	}
}
