package ua.itea.lesson6.tasks;

import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String LETTERS = "-'абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyz"; 
		String CONSONANTS = "бвгджйзклмнпрстфхцчшщbcdfghjklmnpqrstvwxyz";
		String firstLine;
		String secondLine;
		String firstLineLowerCase;
		String secondLineLowerCase;
		
		int firstLineLength  = 0;
		int secondLineLength = 0;
		
		int firstLineWordCount  = 0;
		int secondLineWordCount = 0;
		
		int firstLineConsonantsCount  = 0;
		int secondLineConsonantsCount = 0;
		
		
		System.out.println("Enter first line:");
		firstLine = scanner.nextLine();
		
		System.out.println("Enter second line:");
		secondLine = scanner.nextLine();
		
		scanner.close();
		
		/* Print input */
		System.out.println("---------------------------------");
		System.out.println("First line : \"" + firstLine + "\"");
		System.out.println("Second line: \"" + secondLine + "\"");
		
		
		/* Create lower case strings*/
		firstLineLowerCase  = firstLine.toLowerCase();
		secondLineLowerCase = secondLine.toLowerCase();
		
		/* First task */
		firstLineLength  = firstLine.length();
		secondLineLength = secondLine.length();
		
		/* Second task: word count */
		boolean insideWord = false;
		for (int i = 0; i < firstLineLowerCase.length(); i++) {
			boolean isLetter = false;
			
			/* Find char in LETTERS */
			for (int j = 0; j < LETTERS.length(); j++) {
				if (firstLineLowerCase.charAt(i) == LETTERS.charAt(j)) {
					isLetter = true;
					break;
				}
			}
			
			if (isLetter && !insideWord) {
				insideWord = true;
				firstLineWordCount++;
			} else if (!isLetter) {
				insideWord = false;
			}
		}
		
		insideWord = false;
		for (int i = 0; i < secondLineLowerCase.length(); i++) {
			boolean isLetter = false;
			
			/* Find char in LETTERS */
			for (int j = 0; j < LETTERS.length(); j++) {
				if (secondLineLowerCase.charAt(i) == LETTERS.charAt(j)) {
					isLetter = true;
					break;
				}
			}
			
			if (isLetter && !insideWord) {
				insideWord = true;
				secondLineWordCount++;
			} else if (!isLetter) {
				insideWord = false;
			}
		}
		
		
		/* Third task: consonants count */
		for (int i = 0; i < firstLineLowerCase.length(); i++) {
			for (int j = 0; j < CONSONANTS.length(); j++) {
				if (firstLineLowerCase.charAt(i) == CONSONANTS.charAt(j)) {
					firstLineConsonantsCount++;
				}
			}
		}
		
		for (int i = 0; i < secondLineLowerCase.length(); i++) {
			for (int j = 0; j < CONSONANTS.length(); j++) {
				if (secondLineLowerCase.charAt(i) == CONSONANTS.charAt(j)) {
					secondLineConsonantsCount++;
				}
			}
		}
		
		/* Output */
		System.out.println("---------------------------------");
		
		System.out.println("Length of the first line : " + firstLineLength);
		System.out.println("Length of the second line: " + secondLineLength);
		
		System.out.println("Words in the first line : " + firstLineWordCount);
		System.out.println("Words in the second line: " + secondLineWordCount);
		
		System.out.println("Consonants in the first line : " + firstLineConsonantsCount);
		System.out.println("Consonants in the second line: " + secondLineConsonantsCount);
		
		System.out.println("---------------------------------");
		
		if (firstLineLength > secondLineLength) {
			System.out.println("The first line is longer.");
		} else if (firstLineLength < secondLineLength) {
			System.out.println("The second line is longer.");
		} else {
			System.out.println("Both lines have the same length.");
		}
		
		if (firstLineWordCount > secondLineWordCount) {
			System.out.println("The first line has more words.");
		} else if (firstLineWordCount < secondLineWordCount) {
			System.out.println("The second line has more words.");
		} else {
			System.out.println("Both lines have the same word count.");
		}
		
		if (firstLineConsonantsCount > secondLineConsonantsCount) {
			System.out.println("The first line has more consonants.");
		} else if (firstLineConsonantsCount < secondLineConsonantsCount) {
			System.out.println("The second line has more consonants.");
		} else {
			System.out.println("Both lines have the same consonants count.");
		}
	}

}
