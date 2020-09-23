package ua.itea.lesson13.tasks;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RequesterDouble {
	private Scanner scanner;
	private BoundsDouble bounds;
	
	public RequesterDouble(Scanner scanner, BoundsDouble bounds) {
		setScanner(scanner);
		setBounds(bounds);
	}
	
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void setBounds(BoundsDouble bounds) {
		this.bounds = bounds;
	}
	
	public double next(String label) {
		Pattern patt = Pattern.compile("[^\\n]*\\n");
		double value = 0;
		
		boolean isQuit = false;
		while(!isQuit) {
			System.out.print(label + ": ");
			try {
				value = requestNext();
				isQuit = true;
			} catch(InputMismatchException e) {
				System.out.println("Invalid input: double required");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			
			scanner.skip(patt);
		}
		
		return value;
	}
	
	private double requestNext() {
		double value = scanner.nextDouble();
		
		if (!bounds.isWithin(value)) {
			throw new IllegalArgumentException("Invalid input: "
					+ "value '" + value + "' is out of range "
					+ (bounds.isIncludeMin() ? "[" : "(")
					+ bounds.getMin() + "; " + bounds.getMax()
					+ (bounds.isIncludeMax() ? "]" : ")"));
		}
		
		return value;
	}
}
