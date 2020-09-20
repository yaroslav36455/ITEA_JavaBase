package ua.itea.lesson12.tasks.figure.factory;

import java.util.Scanner;
import ua.itea.lesson12.tasks.figure.Circle;

public class CircleFactory extends RequestedFigureFactory {
	
	public CircleFactory(Scanner scanner) {
		super(scanner);
	}
	
	@Override
	public Circle create() {
		System.out.println("Enter the radius");
		
		return new Circle(lengthRequester.next("Radius"),
					      getRandomColor());
	}
}
