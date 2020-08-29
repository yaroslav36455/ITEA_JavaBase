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
		
		for (int personIter = 0; personIter < people.length; personIter++) {
			System.out.println("Person №" + (personIter + 1));
			
			Scanner lineScanner = new Scanner(scanner.nextLine());
			
			for (int nameIter = 0; nameIter < people[personIter].length; nameIter++) {
				if(lineScanner.hasNext("[a-zA-Zа-яА-Я]+")) {
					people[personIter][nameIter] = lineScanner.next("[a-zA-Zа-яА-Я]+");
				} else {
					System.out.println("Invalid input, try again.");
					personIter--;
					break;
				}
			}
			lineScanner.close();
		}
		
		/* Make lower case copy */
		String[][] lowerCasePeople = new String[people.length][];
		for (int personIter = 0; personIter < people.length; personIter++) {
			lowerCasePeople[personIter] = new String[people[personIter].length];
			for (int nameIter = 0; nameIter < people[personIter].length; nameIter++) {
				lowerCasePeople[personIter][nameIter] = people[personIter][nameIter].toLowerCase();
			}
		}
		
		/* Main loop */
		boolean isQuit = false;
		System.out.println("----------------------------");
		System.out.println("Enter an empty line to quit.");
		while (!isQuit) {
			String[][] found  = new String[people.length][];
			
			/* Request */
			System.out.println("----------------------------");
			System.out.print("Find:");
			String[] lowerCaseWords = scanner.nextLine().toLowerCase().trim().split("[ \t]+");
			if (lowerCaseWords[0].isEmpty()) {
				isQuit = true;
			} else {
				
				/* Find */
				boolean isFound = false;
				for (int personIter = 0; personIter < lowerCasePeople.length; personIter++) {
					for (int nameIter = 0; nameIter < lowerCasePeople[personIter].length; nameIter++) {
						for (int wordIter = 0; wordIter < lowerCaseWords.length; wordIter++) {
							String word = lowerCaseWords[wordIter];
							String name = lowerCasePeople[personIter][nameIter];
							int deltaLength = name.length() - word.length();
							
							/* Find word in name */
							for (int letter = 0; letter <= deltaLength; letter++) {
								String subname = name.substring(letter, letter + word.length());
								if (subname.equals(word)) {
									found[personIter] = people[personIter];
									isFound = true;
									break;
								}
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
		}
		
		System.out.println("Quit");
		scanner.close();
	}

}
