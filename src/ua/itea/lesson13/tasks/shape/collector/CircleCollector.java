package ua.itea.lesson13.tasks.shape.collector;

import java.util.Scanner;

import ua.itea.lesson13.tasks.shape.factory.CircleFactory;

public class CircleCollector extends ShapeCollector {
	
	public CircleCollector(Scanner scanner, int capacity) {
		super(new CircleFactory(scanner), capacity);
	}
}
