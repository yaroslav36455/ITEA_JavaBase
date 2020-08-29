package ua.itea.lesson6.tasks;

import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[][] people = new String[3][3];
		
		/* Create table */
		System.out.println("Add " + people.length + " persons: "
						   + "enter the last name, "
				           + "first name and patronymic, "
				           + "separating them with whitespace.");
		
		for (int i = 0; i < people.length; i++) {
			System.out.println("Person №" + (i + 1));
			
			Scanner lineScanner = new Scanner(scanner.nextLine());
			
			for (int j = 0; j < people[i].length; j++) {
				if(lineScanner.hasNext("[a-zA-Zа-яА-Я]+")) {
					people[i][j] = lineScanner.next("[a-zA-Zа-яА-Я]+");
				} else {
					System.out.println("Invalid input, try again.");
					i--;
					break;
				}
			}
			lineScanner.close();
		}
		
		/* Main loop */
		System.out.println("----------------------------");
		System.out.println("Enter an empty line to quit.");
		while (true) {
			String[][] found  = new String[people.length][];
			
			/* Request */
			System.out.println("----------------------------");
			System.out.print("Find:");
			String[] words = scanner.nextLine().trim().split("[ \t]+");
			if (words[0].isEmpty()) {
				break;
			}
			
			/* Find */
			boolean isFound = false;
			for (int person = 0; person < people.length; person++) {
				for (int part = 0; part < people[person].length; part++) {
					for (int w = 0; w < words.length; w++) {
						String word = words[w].toLowerCase();
						String name = people[person][part].toLowerCase();
						
						if (name.contains(word.subSequence(0, words[w].length()))) {
							found[person] = people[person];
							isFound = true;
						}
					}
				}
			}
			
			/* Print */
			if (isFound) {
				for (int i = 0; i < found.length; i++) {
					if (found[i] != null) {
						isFound = true;
						System.out.print("Found: ");
						for (int j = 0; j < found[i].length; j++) {
							System.out.print(found[i][j] + ((j < found[i].length - 1) ? " " : ""));
						}
						System.out.println();
					}
				}	
			} else {
				System.out.println("Nobody found.");
			}
		}
		
		System.out.println("Quit");
		scanner.close();
	}

}
