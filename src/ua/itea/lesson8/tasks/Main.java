package ua.itea.lesson8.tasks;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FigureFactory factory = new FigureFactory();
		RequesterInteger requester = new RequesterInteger();
		BoundsInteger menuButtons = new BoundsInteger();
		
		menuButtons.set(0, 3);
		menuButtons.include();
		requester.setBounds(menuButtons);
		requester.setScanner(scanner);
		factory.initialize(scanner);
		
		System.out.println("┌───────────┐");
		System.out.println("│   Menu    │");
		System.out.println("│1-Circle   │");
		System.out.println("│2-Rectangle│");
		System.out.println("│3-Triangle │");
		System.out.println("│0-Exit     │");
		System.out.println("└───────────┘");
		
		boolean isQuit = false;
		while(!isQuit) {
			switch (requester.next("Select figure or exit")) {
			case 1:
				System.out.println("1-Circle");
				factory.createCircle().printInfo();
				break;
				
			case 2:
				System.out.println("2-Rectangle");
				factory.createRectangle().printInfo();
				break;	
				
			case 3:
				System.out.println("3-Triangle");
				factory.createTriangle(scanner).printInfo();
				break;
				
			case 0:
				System.out.println("0-Exit");
				isQuit = true;
				break;

			default:
				/* never fall into */
				break;
			}
			
			System.out.println("══════════════════════════════════"
							  +"══════════════════════════════════");
		}

		scanner.close();
	}

}
