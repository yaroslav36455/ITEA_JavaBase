package ua.itea.lesson8.tasks;

import java.util.Scanner;

public class RequesterDouble {
	private Scanner scanner;
	private BoundsDouble bounds = new BoundsDouble();
	
	void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	void setBounds(double boundFirst, double boundSecond) {
		bounds.set(boundFirst, boundSecond);
	}
	
	double next(String label) {
		double value = 0.0;
		
		while (true) {
			System.out.print(label + ": ");
			if (scanner.hasNextDouble()) {
				value = scanner.nextDouble();
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
