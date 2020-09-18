package ua.itea.lesson11.tasks.figure.factory;

import java.util.Scanner;

import ua.itea.lesson11.tasks.BoundsDouble;
import ua.itea.lesson11.tasks.RequesterDouble;
import ua.itea.lesson11.tasks.figure.Circle;

public class CircleFactory extends FigureFactory {
	private BoundsDouble bounds;
	private RequesterDouble lengthRequester;

	public CircleFactory(Scanner scanner) {
		bounds = new BoundsDouble();
		bounds.set(0, Double.MAX_VALUE);
		bounds.exclude();
		
		lengthRequester = new RequesterDouble(scanner, bounds);
	}
	
	@Override
	public Circle create() {
		System.out.println("Enter the radius");
		
		return new Circle(lengthRequester.next("Radius"),
					      getRandomColor());
	}
}
