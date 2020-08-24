package ua.itea.lesson4.tasks;

import java.util.Scanner;

public class Task3 {
	public static void main(String[] args) {
		int arraySize = 0;
		Scanner scanner = new Scanner(System.in);

		/* Guess array size */
		System.out.print("Введите желаемый размер массива: ");
		while (!scanner.hasNextInt() || (arraySize = scanner.nextInt()) < 0) {
			if (arraySize < 0) {
				arraySize = 0;
			} else {
				scanner.next();
			}

			System.out.println("Вы должны ввести неотрицательное число!");
			System.out.print("Введите ещё раз: ");
		}

		/* Create array */
		int[] array = new int[arraySize];

		/* Fill array */
		System.out.println("Теперь заполните массив элементами.");
		for (int i = 0; i < array.length; i++) {
			System.out.print("Элемент № " + (i + 1) + ": ");
			while (!scanner.hasNextInt()) {
				scanner.next();
				System.out.println("Вы должны ввести число!");
				System.out.print("Введите ещё раз: ");
			}
			array[i] = scanner.nextInt();
		}
		scanner.close();

		/* Output */
		System.out.print("Массив [" + arraySize + "]: ");
		System.out.print("{ ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ((i < array.length - 1) ? ", " : ""));
		}
		System.out.println(" }");
	}

}
