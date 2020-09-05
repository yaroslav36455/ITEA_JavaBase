package ua.itea.lesson8.tasks;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FigureFactory factory = new FigureFactory();
		
		factory.setScanner(scanner);
		
		System.out.println("1-Circle");
		System.out.println("2-Rectangle");
		System.out.println("3-Triangle");
		System.out.println("0-Exit");
		
		boolean isQuit = false;
		while(!isQuit) {
			System.out.print("Select figure or exit: ");
			
			if (!scanner.hasNextInt()) {
				scanner.next();
				System.out.println("Invalid input, try again");
				continue;
			}
			
			switch (scanner.nextInt()) {
			case 1:
				factory.createCircle().printInfo();
				break;
				
			case 2:
				factory.createRectangle().printInfo();
				break;	
				
			case 3:
				factory.createTriangle().printInfo();
				break;
				
			case 0:
				System.out.println("0 - Exit");
				isQuit = true;
				break;

			default:
				System.out.println("Invalid input, try again");
				break;
			}
		}

		scanner.close();
	}

}
