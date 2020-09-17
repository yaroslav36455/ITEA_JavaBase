package ua.itea.lesson11.tasks;

import java.util.Scanner;

import ua.itea.lesson11.tasks.figure.Figure;
import ua.itea.lesson11.tasks.figure.factory.CircleFactory;
import ua.itea.lesson11.tasks.figure.factory.RectangleFactory;
import ua.itea.lesson11.tasks.figure.factory.TriangleFactory;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CircleFactory circleFactory = new CircleFactory(scanner);
		RectangleFactory rectangleFactory = new RectangleFactory(scanner);
		TriangleFactory triangleFactory = new TriangleFactory(scanner);
		FigureContainer circleContainer = new FigureContainer(3);
		FigureContainer rectangleContainer = new FigureContainer(3);
		FigureContainer triangleContainer = new FigureContainer(3);
		RequesterInteger requester;
		BoundsInteger menuItems = new BoundsInteger();
		
		menuItems.set(0, 3);
		menuItems.include();
		requester = new RequesterInteger(scanner, menuItems);
		
		System.out.println("┌───────────┐");
		System.out.println("│ Main Menu │");
		System.out.println("│1-Circle   │");
		System.out.println("│2-Rectangle│");
		System.out.println("│3-Triangle │");
		System.out.println("│0-Exit     │");
		System.out.println("└───────────┘");
		
		boolean isQuit = false;
		while(!isQuit && !(circleContainer.isFull()
				&& rectangleContainer.isFull()
				&& triangleContainer.isFull())) {
			
			System.out.println("---------------------------------------------");
			System.out.println("Circles: " + circleContainer.size() + "/" + circleContainer.capacity()
							   + "; Rectangles: " + rectangleContainer.size() + "/" + rectangleContainer.capacity()
							   + "; Triangles: " + triangleContainer.size() + "/" + triangleContainer.capacity());
			
			switch (requester.next("Select figure or exit")) {
			case 1:
				if (!circleContainer.isFull()) {
					System.out.println("1-Circle");
					circleContainer.add(circleFactory.create());
				} else {
					System.out.println("These figures are enough");
				}
				break;
				
			case 2:
				if (!rectangleContainer.isFull()) {
					System.out.println("2-Rectangle");
					rectangleContainer.add(rectangleFactory.create());
				} else {
					System.out.println("These figures are enough");
				}
				break;	
				
			case 3:
				if (!triangleContainer.isFull()) {
					System.out.println("3-Triangle");
					triangleContainer.add(triangleFactory.create());
				} else {
					System.out.println("These figures are enough");
				}
				break;
				
			case 0:
				System.out.println("0-Exit");
				isQuit = true;
				break;

			default:
				/* never fall into */
				break;
			}
		}

		System.out.println("═════════════════════════════════════════════");
		System.out.println("Circles: " + circleContainer.size() + "/" + circleContainer.capacity()
		   + "; Rectangles: " + rectangleContainer.size() + "/" + rectangleContainer.capacity()
		   + "; Triangles: " + triangleContainer.size() + "/" + triangleContainer.capacity());
		System.out.println("---------------------------------------------");
		
		if(circleContainer.isEmpty() && rectangleContainer.isEmpty()
				&& triangleContainer.isEmpty()) {
			System.out.println("No figures");
		} else {
			int i = 0;
			Figure[] figures = new Figure[circleContainer.size()
			                              + rectangleContainer.size()
			                              + triangleContainer.size()];
			
			for (Figure figure : circleContainer.getFigures()) {
				figures[i++] = figure;
			}
			
			for (Figure figure : rectangleContainer.getFigures()) {
				figures[i++] = figure;
			}
			
			for (Figure figure : triangleContainer.getFigures()) {
				figures[i++] = figure;
			}
			
				System.out.println("┏━┯━━━━━━━━━┯━━━━━━━━━┯━━━━━━━━━┯━━━━━━┓");
				System.out.println("┃№│Figure   │Perimeter│Area     │Color ┃");
				System.out.println("┠─┼─────────┼─────────┼─────────┼──────┨");
				String format = "┃%d│%-9s│%.3e│%.3e│%-6s┃\n";

				int counter = 1;

				for (Figure figure : figures) {
					System.out.printf(format, counter++,
									  figure.getName(),
									  figure.getPerimeter(),
									  figure.getArea(),
									  figure.getColor());
				}

				System.out.println("┗━┷━━━━━━━━━┷━━━━━━━━━┷━━━━━━━━━┷━━━━━━┛");
		}
		
		scanner.close();
	}

}
