package ua.itea.lesson8.tasks;

import java.util.Scanner;

public class RequesterInteger {
	private Scanner scanner;
	private BoundsInteger bounds = new BoundsInteger();
	
	void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	void setBounds(int boundFirst, int boundSecond) {
		bounds.set(boundFirst, boundSecond);
	}
	
	int next(String label) {
		int value = 0;
		
		while (true) {
			System.out.print(label + ": ");
			if (scanner.hasNextInt()) {
				value = scanner.nextInt();
				if (bounds.isWithin(value)) {
					break;
				}
			} else {
				scanner.next();				
			}
			
			System.out.println(errorMessage());
		}
		
		return value;
	}
	
	private String errorMessage() {
		return "Invalid input, try again";
	}
}
