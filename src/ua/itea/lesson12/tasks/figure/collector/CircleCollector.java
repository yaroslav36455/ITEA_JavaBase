package ua.itea.lesson12.tasks.figure.collector;

import java.util.Scanner;
import ua.itea.lesson12.tasks.figure.factory.CircleFactory;

public class CircleCollector extends FigureCollector {
	
	public CircleCollector(Scanner scanner, int capacity) {
		super(new CircleFactory(scanner), capacity);
	}
}
