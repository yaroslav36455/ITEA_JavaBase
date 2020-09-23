package ua.itea.lesson13.tasks.shape.collector;

import java.util.Scanner;

import ua.itea.lesson13.tasks.shape.factory.TriangleFactory;

public class TriangleCollector extends ShapeCollector {

	public TriangleCollector(Scanner scanner, int capacity) {
		super(new TriangleFactory(scanner), capacity);
	}
}
