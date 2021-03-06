package ua.itea.lesson15.tasks.shape.collector;

import java.util.Scanner;

import ua.itea.lesson15.tasks.ShapeContainer;
import ua.itea.lesson15.tasks.shape.Circle;
import ua.itea.lesson15.tasks.shape.factory.CircleFactory;

public class CircleCollector extends ShapeCollector {
	private CircleFactory factory;
	
	public CircleCollector(Scanner scanner, ShapeContainer container, int capacity) {
		super(container, capacity);
		factory = new CircleFactory(scanner);
	}
	
	@Override
	protected Circle createClonnedShape() {
		return new Circle(factory.create());
	}
}
