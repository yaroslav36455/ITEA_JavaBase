package ua.itea.lesson11.tasks.figure.factory;

import java.util.Scanner;

import ua.itea.lesson11.tasks.BoundsDouble;
import ua.itea.lesson11.tasks.RequesterDouble;
import ua.itea.lesson11.tasks.figure.Rectangle;

public class RectangleFactory extends FigureFactory {
	private BoundsDouble bounds;
	private RequesterDouble lengthRequester;

	public RectangleFactory(Scanner scanner) {
		bounds = new BoundsDouble();
		bounds.set(0, Double.MAX_VALUE);
		bounds.exclude();
		
		lengthRequester = new RequesterDouble(scanner, bounds);
	}
	
	@Override
	public Rectangle create() {
		System.out.println("Enter the two sides");
		
		return new Rectangle(lengthRequester.next("Side A"),
							 lengthRequester.next("Side B"),
							 getRandomColor());
	}
}
