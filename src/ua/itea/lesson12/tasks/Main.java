package ua.itea.lesson12.tasks;

import java.util.Scanner;

import ua.itea.lesson12.tasks.figure.Figure;
import ua.itea.lesson12.tasks.figure.collector.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int maxFigures = 3;
		FigureCollector circleCollector = new CircleCollector(scanner, maxFigures);
		FigureCollector rectangleCollector = new RectangleCollector(scanner, maxFigures);
		FigureCollector triangleCollector = new TriangleCollector(scanner, maxFigures);

		RequesterInteger menuItemRequester;
		BoundsInteger menuItems = new BoundsInteger();
		
		menuItems.set(0, 3);
		menuItems.include();
		menuItemRequester = new RequesterInteger(scanner, menuItems);
		
		System.out.println("┌───────────┐");
		System.out.println("│ Main Menu │");
		System.out.println("│1-Circle   │");
		System.out.println("│2-Rectangle│");
		System.out.println("│3-Triangle │");
		System.out.println("│0-Exit     │");
		System.out.println("└───────────┘");
		
		boolean isQuit = false;
		while(!isQuit && !(circleCollector.isFull()
						   && rectangleCollector.isFull()
						   && triangleCollector.isFull())) {
			
			System.out.println("---------------------------------------------");
			printFullness("Circles: ", circleCollector);
			printFullness("; Rectangles: ", rectangleCollector);
			printFullness("; Triangles: ", triangleCollector);
			System.out.println();
			
			switch (menuItemRequester.next("Select figure or exit")) {
			case 1:
				System.out.println("1-Circle");
				circleCollector.addFigure();
				break;
				
			case 2:
				System.out.println("2-Rectangle");
				rectangleCollector.addFigure();
				break;	
				
			case 3:
				System.out.println("3-Triangle");
				triangleCollector.addFigure();
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
		printFullness("Circles: ", circleCollector);
		printFullness("; Rectangles: ", rectangleCollector);
		printFullness("; Triangles: ", triangleCollector);
		System.out.println();
		System.out.println("---------------------------------------------");
		
		if(circleCollector.isEmpty() && rectangleCollector.isEmpty()
				&& triangleCollector.isEmpty()) {
			System.out.println("No figures");
		} else {
			/* common container for all figures */
			FigureContainer common = new FigureContainer(circleCollector,
														 rectangleCollector,
														 triangleCollector);
			
				System.out.println("┏━┯━━━━━━━━━┯━━━━━━━━━┯━━━━━━━━━┯━━━━━━┓");
				System.out.println("┃№│Figure   │Perimeter│Area     │Color ┃");
				System.out.println("┠─┼─────────┼─────────┼─────────┼──────┨");
				String format = "┃%d│%-9s│%.3e│%.3e│%-6s┃\n";

				int counter = 1;

				for (Figure figure : common.getFigures()) {
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
	
	private static void printFullness(String label, FigureCollector collector) {
		System.out.print(label + collector.size() + "/" + collector.limit());
	}

}
