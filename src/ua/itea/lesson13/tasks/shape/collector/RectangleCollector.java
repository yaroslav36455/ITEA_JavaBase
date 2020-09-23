package ua.itea.lesson13.tasks.shape.collector;

import java.util.Scanner;

import ua.itea.lesson13.tasks.shape.factory.RectangleFactory;

public class RectangleCollector extends ShapeCollector {

	public RectangleCollector(Scanner scanner, int capacity) {
		super(new RectangleFactory(scanner), capacity);
	}
}
