package ua.itea.lesson11.tasks.figure.collector;

import java.util.Scanner;
import ua.itea.lesson11.tasks.figure.factory.TriangleFactory;

public class TriangleCollector extends FigureCollector {

	public TriangleCollector(Scanner scanner, int capacity) {
		super(new TriangleFactory(scanner), capacity);
	}
}
