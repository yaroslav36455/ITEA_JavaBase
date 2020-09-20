package ua.itea.lesson12.tasks.figure.factory;

import java.util.Scanner;
import ua.itea.lesson12.tasks.figure.Rectangle;

public class RectangleFactory extends RequestedFigureFactory {
	
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
