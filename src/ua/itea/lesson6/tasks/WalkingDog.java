package ua.itea.lesson6.tasks;

import java.util.Arrays;
import java.util.Scanner;

public class WalkingDog {

	public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
		
		/* Game field */
		char[][] field = new char[10][10];
		
		/* Game state */
		boolean isGameOver = false;
		boolean isQuit = false;
		int health = 100;
		int dogPosRow = 0;
		int dogPosCol = 0;
		int[] bombPos = new int [field.length];
		int[] aidPos  = new int [field.length];
		boolean[] isSteppedOnBomb = new boolean[field[0].length]; // only rectangular field allowed!
		boolean[] isSteppedOnAid  = new boolean[field[0].length]; // only rectangular field allowed!
		
		/* Step constants */
		int STEP_PAYMENT = -5;
		int STEP_ON_BOMB_PAYMENT = -40;
		int STEP_ON_AID_PAYMENT  = 40;
		
		/* Items */
		char floor = '_';
		char dog   = '@';
		char bomb  = '*';
		char aid   = '+';
		
		/* Buttons */
		char buttonPressed;
		final char BUTTON_LEFT  = 'a';
		final char BUTTON_RIGHT = 'd';
		final char BUTTON_UP    = 'w';
		final char BUTTON_DOWN  = 's';
		final char BUTTON_QUIT  = 'q';
		
		/* Print info */
		System.out.println("Control:");
		System.out.println(" left  - '" + BUTTON_LEFT  + '\'');
		System.out.println(" right - '" + BUTTON_RIGHT + '\'');
		System.out.println(" up    - '" + BUTTON_UP    + '\'');
		System.out.println(" down  - '" + BUTTON_DOWN  + '\'');
		System.out.println(" quit  - '" + BUTTON_QUIT  + '\'');
		System.out.println("(any other presses are ignored)");
		
		/* Fill field */
		for (int i = 0; i < bombPos.length; i++) {
			do {
				bombPos[i] = (int) (Math.random() * field[i].length);
			} while((dogPosRow == i) && (dogPosCol == bombPos[i]));	
		}
		for (int i = 0; i < aidPos.length; i++) {
			do {
				aidPos[i] = (int) (Math.random() * field[i].length);
			} while(((dogPosRow == i) && (dogPosCol == aidPos[i])) || (aidPos[i] == bombPos[i]));	
		}
		
		/* Initialize field */
		for (int i = 0; i < field.length; i++) {
			Arrays.fill(field[i], floor);
			field[i][bombPos[i]] = bomb;
			field[i][aidPos[i]]  = aid;	
		}
		
		while(!isQuit) {
			
			/* Update dog item */
			field[dogPosRow][dogPosCol] = dog;
			
			/* Draw */
			for (int i = 0; i < field[0].length + 2; i++) {
				System.out.print('━');	
			}
			System.out.println();
			System.out.println("health: " + health);
			System.out.print('┌');
			for (int i = 0; i < field[0].length; i++) {
				System.out.print('─');
			}
			System.out.println('┐');
			for (int row = 0; row < field.length; row++) {
				System.out.print("│");
				for (int col = 0; col < field[row].length; col++) {
					System.out.print(field[row][col]);
				}	
				System.out.println("│");
			}
			System.out.print('└');
			for (int i = 0; i < field[0].length; i++) {
				System.out.print('─');
			}
			System.out.println('┘');
			
			/* Request pressing */
			System.out.print("press: ");
			buttonPressed = scanner.next().charAt(0);
			
			/* Handle key press */
			switch (buttonPressed) {
			case BUTTON_LEFT:
				field[dogPosRow][dogPosCol--] = floor;
				break;
				
			case BUTTON_RIGHT:
				field[dogPosRow][dogPosCol++] = floor;
				break;
				
			case BUTTON_UP:
				field[dogPosRow--][dogPosCol] = floor;
				break;
				
			case BUTTON_DOWN:
				field[dogPosRow++][dogPosCol] = floor;
				break;
				
			case BUTTON_QUIT:
				isQuit = true;
				/* falls through */
			default:
				continue;
			}
			
			/* is Game Over: out of field*/
			if ((dogPosRow < 0 || dogPosRow >= field.length)
					|| (dogPosCol < 0 || dogPosCol >= field[dogPosRow].length)) {
				isGameOver = true;
				isQuit = true;
				continue;
			}
			
			/* Health update */
			health += STEP_PAYMENT;
			if (!isSteppedOnBomb[dogPosRow] && (dogPosCol == bombPos[dogPosRow])) {
				health += STEP_ON_BOMB_PAYMENT;
				isSteppedOnBomb[dogPosRow] = true;
			} else if (!isSteppedOnAid[dogPosRow] && (dogPosCol == aidPos[dogPosRow])) {
				health += STEP_ON_AID_PAYMENT;
				isSteppedOnAid[dogPosRow] = true;
			}
			
			/* is Game Over: no health */
			if (health < 1) {
				isGameOver = true;
				isQuit = true;
			}
		}
		
		System.out.println("------------");
		if (isGameOver) {
			System.out.println("Health: " + health);
			System.out.println("Game Over");
		}
		System.out.println("Quit");
		
		scanner.close();
	}

}
