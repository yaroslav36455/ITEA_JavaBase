package ua.itea.lesson12.tasks.figure.factory;

import java.util.Scanner;

import ua.itea.lesson12.tasks.Angle;
import ua.itea.lesson12.tasks.BoundsDouble;
import ua.itea.lesson12.tasks.BoundsInteger;
import ua.itea.lesson12.tasks.RequesterDouble;
import ua.itea.lesson12.tasks.RequesterInteger;
import ua.itea.lesson12.tasks.figure.Triangle;

public class TriangleFactory extends RequestedFigureFactory {
	private BoundsDouble angleBounds;
	private RequesterDouble angleRequester;
	private RequesterInteger menuItemRequester;
	
	public TriangleFactory(Scanner scanner) {
		super(scanner);
		
		angleBounds = new BoundsDouble();
		angleBounds.exclude();
		angleRequester = new RequesterDouble(scanner, angleBounds);
		
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
		
		sideA = requestNextLength("Side A");
		sideB = requestNextLength("Side B");
		
		angleBounds.set(0, 180);
		angleAB.setDegree(angleRequester.next("Angle AB"));
		
		return new Triangle(sideA, sideB, angleAB, getRandomColor());
	}
	
	private Triangle createTriangleOneSideAndTwoAngles() {
		double sideA;
		Angle angleAB = new Angle();
		Angle angleAC = new Angle();
		
		System.out.println("Enter one side and two adjacent angles");
		
		sideA = requestNextLength("Side A");
		
		angleBounds.set(0, 180);
		angleAB.setDegree(angleRequester.next("Angle AB"));

		angleBounds.set(0, 180 - angleAB.getDegree());
		angleAC.setDegree(angleRequester.next("Angle AC"));
		
		return new Triangle(sideA, angleAB, angleAC, getRandomColor());
	}
}
