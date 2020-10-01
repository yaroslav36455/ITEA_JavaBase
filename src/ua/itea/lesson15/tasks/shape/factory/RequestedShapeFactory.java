package ua.itea.lesson15.tasks.shape.factory;

import java.util.Scanner;

import ua.itea.lesson15.tasks.RangeDouble;
import ua.itea.lesson15.tasks.RequesterDouble;

public class RequestedShapeFactory extends ShapeFactory {
	private RequesterDouble lengthRequester;
	
	public RequestedShapeFactory(Scanner scanner) {
		RangeDouble lengthRange = new RangeDouble();
		lengthRange.set(0, Double.MAX_VALUE);
		lengthRange.exclude();
		
		lengthRequester = new RequesterDouble(scanner, lengthRange);
	}
	
	protected double requestNextLength(String label) {
		return lengthRequester.next(label);
	}
}
