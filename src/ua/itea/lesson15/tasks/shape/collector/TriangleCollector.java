package ua.itea.lesson15.tasks.shape.collector;

import java.util.Scanner;

import ua.itea.lesson15.tasks.ShapeContainer;
import ua.itea.lesson15.tasks.shape.Triangle;
import ua.itea.lesson15.tasks.shape.factory.TriangleFactory;

public class TriangleCollector extends ShapeCollector {
	private TriangleFactory factory;

	public TriangleCollector(Scanner scanner, ShapeContainer container, int capacity) {
		super(container, capacity);
		factory = new TriangleFactory(scanner);
	}
	
	@Override
	protected Triangle createClonnedShape() {
		return new Triangle(factory.create());
	}
}
