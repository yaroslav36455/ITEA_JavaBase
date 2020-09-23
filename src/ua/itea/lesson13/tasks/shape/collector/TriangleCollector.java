package ua.itea.lesson13.tasks.shape.collector;

import java.util.Scanner;

import ua.itea.lesson13.tasks.shape.Triangle;
import ua.itea.lesson13.tasks.shape.factory.TriangleFactory;

public class TriangleCollector extends ShapeCollector {
	private TriangleFactory factory;

	public TriangleCollector(Scanner scanner, int capacity) {
		super(capacity);
		factory = new TriangleFactory(scanner);
	}
	
	@Override
	protected Triangle createClonnedShape() {
		return new Triangle(factory.create());
	}
}
