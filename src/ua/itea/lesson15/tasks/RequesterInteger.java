package ua.itea.lesson15.tasks;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RequesterInteger {
	private Scanner scanner;
	private RangeInteger range;
	
	public RequesterInteger(Scanner scanner, RangeInteger range) {
		setScanner(scanner);
		setRange(range);
	}
	
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void setRange(RangeInteger range) {
		this.range = range;
	}
	
	public int next(String label) {
		Pattern patt = Pattern.compile("[^\\n]*\\n");
		int value = 0;
		
		boolean isQuit = false;
		while(!isQuit) {
			System.out.print(label + ": ");
			try {
				value = requestNext();
				isQuit = true;
			} catch(InputMismatchException e) {
				System.out.println("Invalid input: integer required");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			
			scanner.skip(patt);
		}
		
		return value;
	}
	
	private int requestNext() {
		int value = scanner.nextInt();
		
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
