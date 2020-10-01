package ua.itea.lesson15.tasks.shape.factory;

import java.util.Scanner;

import ua.itea.lesson15.tasks.Angle;
import ua.itea.lesson15.tasks.RangeDouble;
import ua.itea.lesson15.tasks.RangeInteger;
import ua.itea.lesson15.tasks.RequesterDouble;
import ua.itea.lesson15.tasks.RequesterInteger;
import ua.itea.lesson15.tasks.shape.Triangle;

public class TriangleFactory extends RequestedShapeFactory {
	private RangeDouble angleRange;
	private RequesterDouble angleRequester;
	private RequesterInteger menuItemRequester;
	
	public TriangleFactory(Scanner scanner) {
		super(scanner);
		
		angleRange = new RangeDouble();
		angleRange.exclude();
		angleRequester = new RequesterDouble(scanner, angleRange);
		
		RangeInteger menuItems = new RangeInteger();
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
		
		angleRange.set(0, 180);
		angleAB.setDegree(angleRequester.next("Angle AB"));
		
		return new Triangle(sideA, sideB, angleAB, getRandomColor());
	}
	
	private Triangle createTriangleOneSideAndTwoAngles() {
		double sideA;
		Angle angleAB = new Angle();
		Angle angleAC = new Angle();
		
		System.out.println("Enter one side and two adjacent angles");
		
		sideA = requestNextLength("Side A");
		
		angleRange.set(0, 180);
		angleAB.setDegree(angleRequester.next("Angle AB"));

		angleRange.set(0, 180 - angleAB.getDegree());
		angleAC.setDegree(angleRequester.next("Angle AC"));
		
		return new Triangle(sideA, angleAB, angleAC, getRandomColor());
	}
}
