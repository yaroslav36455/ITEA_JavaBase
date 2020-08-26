package ua.itea.lesson5.tasks;

import java.util.Arrays;
import java.util.Scanner;

public class WalkingDog {

	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		
		/* Game state */
		boolean isGameOver = false;
		boolean isQuit = false;
		int dogPos = 0;
		int health = 100;
		int stepPayment = -5;
		
		/* Buttons */
		char buttonPressed;
		char leftButton  = 'a';
		char rightButton = 'd';
		char quitButton  = 'q';
		
		/* Game field */
		char[] field = new char[10];
		char floor = '_';
		char dog   = '@';
		Arrays.fill(field, floor);
		
		/* Print info */
		System.out.println("Control:");
		System.out.println(" left  - '" + leftButton  + "';");
		System.out.println(" right - '" + rightButton + "';");
		System.out.println(" quit  - '" + quitButton  + "'.");
		System.out.println("-------------");
		
		while(!isQuit) {
			
			/* Update */
			field[dogPos] = dog;
			
			/* Draw */
			System.out.print("[");
			for (int i = 0; i < field.length; i++) {
				System.out.print(field[i]);
			}
			System.out.print("] | health: " + health);
			
			/* Request pressing */
			System.out.print(" | press: ");
			buttonPressed = scanner.next().charAt(0);
			
			/* Handle key press */
			if (buttonPressed == quitButton) {
				isQuit = true;
			} else if (buttonPressed == leftButton) {
				field[dogPos--] = floor;
				health += stepPayment;
			} else if (buttonPressed == rightButton) {
				field[dogPos++] = floor;
				health += stepPayment;
			}
			
			/* is Game Over */
			if ((dogPos < 0 || dogPos >= field.length) || health < 1) {
				isGameOver = true;
				isQuit = true;
			}	
		}
		
		scanner.close();
		if (isGameOver) {
			System.out.println("Health: " + health);
			System.out.println("Game Over");
		}
		System.out.println("Quit");
	}

}
