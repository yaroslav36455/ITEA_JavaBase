package ua.itea.lesson11.tasks.figure.factory;

import java.util.Scanner;

import ua.itea.lesson11.tasks.BoundsDouble;
import ua.itea.lesson11.tasks.RequesterDouble;

public class RequestedFigureFactory extends FigureFactory {
	protected RequesterDouble lengthRequester;
	
	public RequestedFigureFactory(Scanner scanner) {
		BoundsDouble lengthBounds = new BoundsDouble();
		lengthBounds.set(0, Double.MAX_VALUE);
		lengthBounds.exclude();
		
		lengthRequester = new RequesterDouble(scanner, lengthBounds);
	}
}
