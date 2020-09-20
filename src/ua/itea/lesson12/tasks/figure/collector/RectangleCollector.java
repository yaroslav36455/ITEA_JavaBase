package ua.itea.lesson12.tasks.figure.collector;

import java.util.Scanner;

import ua.itea.lesson12.tasks.figure.factory.RectangleFactory;

public class RectangleCollector extends FigureCollector {

	public RectangleCollector(Scanner scanner, int capacity) {
		super(new RectangleFactory(scanner), capacity);
	}
}
