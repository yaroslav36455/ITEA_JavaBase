package ua.itea.lesson13.tasks;

import java.util.Scanner;

import ua.itea.lesson13.tasks.shape.collector.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int maxShapes = 3;
		ShapeCollector circleCollector = new CircleCollector(scanner, maxShapes);
		ShapeCollector rectangleCollector = new RectangleCollector(scanner, maxShapes);
		ShapeCollector triangleCollector = new TriangleCollector(scanner, maxShapes);

		RequesterInteger menuItemRequester;
		RangeInteger menuItems = new RangeInteger();
		
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
			
			switch (menuItemRequester.next("Select shape or exit")) {
			case 1:
				System.out.println("1-Circle");
				circleCollector.addShape();
				break;
				
			case 2:
				System.out.println("2-Rectangle");
				rectangleCollector.addShape();
				break;	
				
			case 3:
				System.out.println("3-Triangle");
				triangleCollector.addShape();
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
		
		/* common container for all shapes */
		System.out.println(new ShapeContainer(circleCollector,
											  rectangleCollector,
											  triangleCollector));
		
		scanner.close();
	}
	
	private static void printFullness(String label, ShapeCollector collector) {
		System.out.print(label + collector.size() + "/" + collector.limit());
	}

}
