package ua.itea.lesson13.tasks.shape.collector;

import java.util.Scanner;

import ua.itea.lesson13.tasks.shape.Circle;
import ua.itea.lesson13.tasks.shape.factory.CircleFactory;

public class CircleCollector extends ShapeCollector {
	private CircleFactory factory;
	
	public CircleCollector(Scanner scanner, int capacity) {
		super(capacity);
		factory = new CircleFactory(scanner);
	}
	
	@Override
	protected Circle createClonnedShape() {
		return new Circle(factory.create());
	}
}
