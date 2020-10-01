package ua.itea.lesson15.tasks.shape.collector;

import java.util.Scanner;

import ua.itea.lesson15.tasks.shape.Rectangle;
import ua.itea.lesson15.tasks.shape.factory.RectangleFactory;

public class RectangleCollector extends ShapeCollector {
	private RectangleFactory factory;

	public RectangleCollector(Scanner scanner, int capacity) {
		super(capacity);
		factory = new RectangleFactory(scanner);
	}
	
	@Override
	protected Rectangle createClonnedShape() {
		return new Rectangle(factory.create());
	}
}
