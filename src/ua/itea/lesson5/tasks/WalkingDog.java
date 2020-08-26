package ua.itea.lesson5.tasks;

import java.util.Arrays;
import java.util.Scanner;

public class WalkingDog {

	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		
		/* Game state */
		boolean isGameOver = false;
		boolean isQuit = false;
		int health = 100;
		int dogPos = 0;
		int bombPos = (int) (Math.random() * 9) + 1;
		int aidPos  = bombPos;
		while (aidPos == bombPos) {
			aidPos = (int) (Math.random() * 9) + 1;
		}
		boolean isSteppedOnBomb = false;
		boolean isSteppedOnAid  = false;
		
		/* Step constants */
		int STEP_PAYMENT = -5;
		int STEP_ON_BOMB_PAYMENT = -40;
		int STEP_ON_AID_PAYMENT  = 40;
		
		/* Buttons */
		char buttonPressed;
		char leftButton  = 'a';
		char rightButton = 'd';
		char quitButton  = 'q';
		
		/* Print info */
		System.out.println("Control:");
		System.out.println(" left  - '" + leftButton  + "';");
		System.out.println(" right - '" + rightButton + "';");
		System.out.println(" quit  - '" + quitButton  + "'.");
		System.out.println("-------------");
		
		/* Game field */
		char[] field = new char[10];
		char floor = '_';
		char dog   = '@';
		char bomb  = '*';
		char aid   = '+';
		Arrays.fill(field, floor);
		field[bombPos] = bomb;
		field[aidPos]  = aid;
		
		while(!isQuit) {
			
			/* Update position */
			field[dogPos]  = dog;
			
			/* Draw */
			System.out.print("[");
			for (int i = 0; i < field.length; i++) {
				System.out.print(field[i]);
			}
			System.out.printf("] | health: %3d", health);
			
			/* Request pressing */
			System.out.print(" | press: ");
			buttonPressed = scanner.next().charAt(0);
			
			/* Handle key press */
			if (buttonPressed == quitButton) {
				isQuit = true;
			} else if (buttonPressed == leftButton) {
				field[dogPos--] = floor;
			} else if (buttonPressed == rightButton) {
				field[dogPos++] = floor;
			}
			
			/* Health update */
			health += STEP_PAYMENT;
			if (!isSteppedOnBomb && (dogPos == bombPos)) {
				health += STEP_ON_BOMB_PAYMENT;
				isSteppedOnBomb = true;
			} else if (!isSteppedOnAid && (dogPos == aidPos)) {
				health += STEP_ON_AID_PAYMENT;
				isSteppedOnAid = true;
			}
			
			/* is Game Over */
			if ((dogPos < 0 || dogPos >= field.length) || health < 1) {
				isGameOver = true;
				isQuit = true;
			}
		}
		
		if (isGameOver) {
			System.out.println("Health: " + health);
			System.out.println("Game Over");
		}
		System.out.println("Quit");
		
		scanner.close();
	}

}
