package ua.itea.lesson12.tasks.figure.factory;

import java.util.Scanner;

import ua.itea.lesson12.tasks.BoundsDouble;
import ua.itea.lesson12.tasks.RequesterDouble;

public class RequestedFigureFactory extends FigureFactory {
	private RequesterDouble lengthRequester;
	
	public RequestedFigureFactory(Scanner scanner) {
		BoundsDouble lengthBounds = new BoundsDouble();
		lengthBounds.set(0, Double.MAX_VALUE);
		lengthBounds.exclude();
		
		lengthRequester = new RequesterDouble(scanner, lengthBounds);
	}
	
	protected double requestNextLength(String label) {
		return lengthRequester.next(label);
	}
}
