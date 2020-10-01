package ua.itea.lesson15.tasks.shape.factory;

import java.util.Scanner;

import ua.itea.lesson15.tasks.shape.Circle;

public class CircleFactory extends RequestedShapeFactory {
	
	public CircleFactory(Scanner scanner) {
		super(scanner);
	}
	
	@Override
	public Circle create() {
		System.out.println("Enter the radius");
		
		return new Circle(requestNextLength("Radius"),
					      getRandomColor());
	}
}
