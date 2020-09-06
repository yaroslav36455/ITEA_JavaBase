package ua.itea.lesson8.tasks;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FigureFactory factory = new FigureFactory();
		RequesterInteger requester = new RequesterInteger();
		
		factory.initialize(scanner);
		requester.setScanner(scanner);
		requester.setBounds(0, 3);
		
		System.out.println("1-Circle");
		System.out.println("2-Rectangle");
		System.out.println("3-Triangle");
		System.out.println("0-Exit");
		
		boolean isQuit = false;
		while(!isQuit) {
			switch (requester.next("Select figure or exit")) {
			case 1:
				System.out.print("1-Circle");
				factory.createCircle().printInfo();
				break;
				
			case 2:
				System.out.print("2-Rectangle");
				factory.createRectangle().printInfo();
				break;	
				
			case 3:
				System.out.print("3-Triangle");
				factory.createTriangle().printInfo();
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

		scanner.close();
	}

}
