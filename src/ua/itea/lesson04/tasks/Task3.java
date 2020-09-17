package ua.itea.lesson04.tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
	public static void main(String[] args) {
		int arraySize;
		Scanner scanner = new Scanner(System.in);

		/* Guess array size */
		System.out.print("Введите желаемый размер массива: ");
		while (true) {
			if (scanner.hasNextInt()) {
				arraySize = scanner.nextInt();
				if (arraySize >= 0)
					break;
			} else {
				scanner.next();
			}
			
			System.out.println("Вы должны ввести неотрицательное число!");
			System.out.print("Введите ещё раз: ");
		}

		/* Create array */
		int[] array = new int[arraySize];

		/* Fill array */
		if (arraySize > 0) {
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
		}
		scanner.close();

		/* Output */
		System.out.print("Массив [" + arraySize + "]: ");
		System.out.println(Arrays.toString(array));
	}

}
