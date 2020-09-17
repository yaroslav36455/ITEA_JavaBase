package ua.itea.lesson11.tasks;

import java.util.Scanner;
import ua.itea.lesson11.tasks.figure.factory.FigureFactory;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FigureFactory factory = new FigureFactory(scanner);
		FigureContainer container = new FigureContainer(3, 3, 3);
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
		while(!isQuit && !container.isFull()) {
			
			System.out.println("---------------------------------------------");
			container.printFullnessInfo();
			
			switch (requester.next("Select figure or exit")) {
			case 1:
				if (!container.isFullOfCircles()) {
					System.out.println("1-Circle");
					container.add(factory.createCircle());	
				} else {
					System.out.println("These figures are enough");
				}
				break;
				
			case 2:
				if (!container.isFullOfRectangles()) {
					System.out.println("2-Rectangle");
					container.add(factory.createRectangle());
				} else {
					System.out.println("These figures are enough");
				}
				break;	
				
			case 3:
				if (!container.isFullOfTriangles()) {
					System.out.println("3-Triangle");
					container.add(factory.createTriangle(scanner));
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
		container.printFullnessInfo();
		System.out.println("---------------------------------------------");
		container.printFiguresInfo();

		scanner.close();
	}

}
