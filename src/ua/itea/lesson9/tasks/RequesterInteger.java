package ua.itea.lesson9.tasks;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RequesterInteger {
	private Scanner scanner;
	private BoundsInteger bounds;
	
	void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	void setBounds(BoundsInteger bounds) {
		this.bounds = bounds;
	}
	
	int next(String label) {
		Pattern patt = Pattern.compile("[^\\n]*\\n");
		int value = 0;
		
		while (true) {
			System.out.print(label + ": ");
			if (scanner.hasNextInt()) {
				value = scanner.nextInt();
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
