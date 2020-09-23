package ua.itea.lesson13.tasks;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RequesterInteger {
	private Scanner scanner;
	private BoundsInteger bounds;
	
	public RequesterInteger(Scanner scanner, BoundsInteger bounds) {
		setScanner(scanner);
		setBounds(bounds);
	}
	
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void setBounds(BoundsInteger bounds) {
		this.bounds = bounds;
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
