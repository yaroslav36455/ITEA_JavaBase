package ua.itea.lesson15.tasks.shape.factory;

import java.util.Scanner;

import ua.itea.lesson15.tasks.shape.Rectangle;

public class RectangleFactory extends RequestedShapeFactory {
	
	public RectangleFactory(Scanner scanner) {
		super(scanner);
	}
	
	@Override
	public Rectangle create() {
		System.out.println("Enter the two sides");
		
		return new Rectangle(requestNextLength("Side A"),
							 requestNextLength("Side B"),
							 getRandomColor());
	}
}
