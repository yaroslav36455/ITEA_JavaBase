package ua.itea.lesson9.tasks;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RequesterDouble {
	private Scanner scanner;
	private BoundsDouble bounds;
	
	public RequesterDouble(Scanner scanner, BoundsDouble bounds) {
		setScanner(scanner);
		setBounds(bounds);
	}
	
	void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	void setBounds(BoundsDouble bounds) {
		this.bounds = bounds;
	}
	
	double next(String label) {
		Pattern patt = Pattern.compile("[^\\n]*\\n");
		double value = 0.0;
		
		while (true) {
			System.out.print(label + ": ");
			if (scanner.hasNextDouble()) {
				value = scanner.nextDouble();
				if (bounds.isWithin(value)) {
					break;
				}
			}
			
			scanner.skip(patt);
			System.out.println(errorMessage());
		}
		
		scanner.skip(patt);
		return value;
	}
	
	private String errorMessage() {
		return "Invalid input, try again";
	}
}
