package ua.itea.lesson05.tasks;

import java.util.Arrays;
import java.util.Scanner;

public class WalkingDog {

	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		
		/* Game field */
		char[] field = new char[10];
		
		/* Game state */
		boolean isGameOver = false;
		boolean isQuit = false;
		int health = 100;
		int dogPos = 0;
		int bombPos;
		do {
			bombPos = (int) (Math.random() * field.length);
		} while(bombPos == dogPos);
		int aidPos;
		do {
			aidPos = (int) (Math.random() * field.length);
		} while(aidPos == dogPos || aidPos == bombPos);
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
		System.out.println("(any other presses are ignored)");
		System.out.println("-------------");
		
		/* Items */
		char floor = '_';
		char dog   = '@';
		char bomb  = '*';
		char aid   = '+';
		
		/* Initialize field */
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
			if (buttonPressed == leftButton) {
				field[dogPos--] = floor;
			} else if (buttonPressed == rightButton) {
				field[dogPos++] = floor;
			} else {
				isQuit = buttonPressed == quitButton;
				continue;
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
