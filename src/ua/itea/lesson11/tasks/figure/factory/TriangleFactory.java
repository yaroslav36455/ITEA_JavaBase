package ua.itea.lesson11.tasks.figure.factory;

import java.util.Scanner;

import ua.itea.lesson11.tasks.Angle;
import ua.itea.lesson11.tasks.BoundsDouble;
import ua.itea.lesson11.tasks.BoundsInteger;
import ua.itea.lesson11.tasks.RequesterDouble;
import ua.itea.lesson11.tasks.RequesterInteger;
import ua.itea.lesson11.tasks.figure.Triangle;

public class TriangleFactory extends FigureFactory {
	private BoundsDouble bounds;
	private RequesterDouble requester;
	private RequesterInteger menuItemRequester;
	
	public TriangleFactory(Scanner scanner) {
		bounds = new BoundsDouble();
		bounds.exclude();
		requester = new RequesterDouble(scanner, bounds);
		
		BoundsInteger menuItems = new BoundsInteger();
		menuItems.set(1, 2);
		menuItems.include();
		menuItemRequester = new RequesterInteger(scanner, menuItems);
	}

	@Override
	public Triangle create() {
		Triangle triangle = null;
		
		System.out.println("┌─────────────────────────┐");
		System.out.println("│ Computation Method Menu │");
		System.out.println("│1-Two sides and angle    │");
		System.out.println("│2-One side and two angles│");
		System.out.println("└─────────────────────────┘");
		
		switch (menuItemRequester.next("Select computation method")) {
		case 1:
			triangle = createTriangleTwoSidesAndOneAngle();
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
	
	private Triangle createTriangleTwoSidesAndOneAngle() {
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
							getRandomColor());
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
		
		return new Triangle(sideA, angleAB, angleAC, getRandomColor());
	}
}
