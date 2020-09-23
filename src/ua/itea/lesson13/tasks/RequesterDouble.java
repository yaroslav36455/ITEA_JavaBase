package ua.itea.lesson13.tasks;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RequesterDouble {
	private Scanner scanner;
	private RangeDouble range;
	
	public RequesterDouble(Scanner scanner, RangeDouble range) {
		setScanner(scanner);
		setRange(range);
	}
	
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void setRange(RangeDouble range) {
		this.range = range;
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
		
		if (!range.isWithin(value)) {
			throw new IllegalArgumentException("Invalid input: "
					+ "value '" + value + "' is out of range "
					+ (range.isIncludeMin() ? "[" : "(")
					+ range.getMin() + "; " + range.getMax()
					+ (range.isIncludeMax() ? "]" : ")"));
		}
		
		return value;
	}
}
