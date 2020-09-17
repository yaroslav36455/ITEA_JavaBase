package ua.itea.lesson04;

import java.util.Scanner;

public class First {

	public static void main(String[] args) {
//		int age = -1;
//		Scanner scanner = new Scanner(System.in);
//		
//		
//		do {
//			System.out.println("Введите ваш возвраст:");
//			if (scanner.hasNextInt()) {
//				age = scanner.nextInt();
//				break;
//			} else {
//				System.out.println("Вы должны ввести число!");
//				scanner.next();
//			}
//		} while (true);
//
//		System.out.println("Ваш возвраст: " + age);
		
		
		Scanner scanner = new Scanner(System.in);
		int value = (int) (Math.random() * 101);
		int testValue;
		
		//System.out.println(value);
		
		System.out.println("Угадайте число от 0 до 100 за пять попыток");
		int i;
		boolean win = false;
		for (i = 1; i <= 5; i++) {
			System.out.println("Попытка №" + i + ", введите число:");
			testValue = scanner.nextInt();
			
			if (testValue == value) {
				System.out.println("Вы угадали!");
				win = true;
				break;
			} else if (testValue < value) {
				System.out.println("Число меньше необходимого.");
			} else {
				System.out.println("Число больше необходимого.");
			}	
		}
		
		System.out.println(win ? "Вы выиграли." : "Вы проиграли.");
		
		scanner.close();
	}

}
