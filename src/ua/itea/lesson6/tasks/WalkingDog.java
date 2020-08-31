package ua.itea.lesson6.tasks;

import java.util.Arrays;
import java.util.Scanner;

public class WalkingDog {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/* Game field */
		int height = 10;
		int width  = 10;
		char[][] field = new char[height][width];
		
		/* Game state */
		boolean isGameOver = false;
		boolean isQuit = false;
		int health = 100;
		int dogPosRow = 0;
		int dogPosCol = 0;
		int[] bombPos = new int[height];
		int[] aidPos  = new int[height];
		boolean[] isSteppedOnBomb = new boolean[width];
		boolean[] isSteppedOnAid  = new boolean[width];
		
		/* Step constants */
		int STEP_PAYMENT = -5;
		int STEP_ON_BOMB_PAYMENT = -40;
		int STEP_ON_AID_PAYMENT  = 40;
		
		/* Items */
		char floor = '_';
		char dog   = '@';
		char bomb  = '*';
		char aid   = '+';
		
		/* Button */
		char buttonPressed;
		
		/* Print info */
		System.out.println("Control:");
		System.out.println(" left  - '" + 'a' + '\'');
		System.out.println(" right - '" + 'd' + '\'');
		System.out.println(" up    - '" + 'w' + '\'');
		System.out.println(" down  - '" + 's' + '\'');
		System.out.println(" quit  - '" + 'q' + '\'');
		System.out.println("(any other presses are ignored)");
		
		/* Fill field */
		for (int i = 0; i < height; i++) {
			do {
				bombPos[i] = (int) (Math.random() * width);
			} while((dogPosRow == i) && (dogPosCol == bombPos[i]));	
		}
		for (int i = 0; i < height; i++) {
			do {
				aidPos[i] = (int) (Math.random() * width);
			} while(((dogPosRow == i) && (dogPosCol == aidPos[i])) || (aidPos[i] == bombPos[i]));	
		}
		
		/* Initialize field */
		for (int i = 0; i < height; i++) {
			Arrays.fill(field[i], floor);
			field[i][bombPos[i]] = bomb;
			field[i][aidPos[i]]  = aid;	
		}
		
		while(!isQuit) {
			
			/* Update dog item */
			field[dogPosRow][dogPosCol] = dog;
			
			/* Draw */
			for (int i = 0; i < width + 2; i++) {
				System.out.print('━');	
			}
			System.out.println();
			System.out.println("health: " + health);
			System.out.print('┌');
			for (int i = 0; i < width; i++) {
				System.out.print('─');
			}
			System.out.println('┐');
			for (int row = 0; row < height; row++) {
				System.out.print("│");
				for (int col = 0; col < width; col++) {
					System.out.print(field[row][col]);
				}	
				System.out.println("│");
			}
			System.out.print('└');
			for (int i = 0; i < width; i++) {
				System.out.print('─');
			}
			System.out.println('┘');
			
			/* Request pressing */
			System.out.print("press: ");
			buttonPressed = scanner.next().charAt(0);
			
			/* Handle key press */
			switch (buttonPressed) {
			case 'a':
				field[dogPosRow][dogPosCol--] = floor;
				break;
				
			case 'd':
				field[dogPosRow][dogPosCol++] = floor;
				break;
				
			case 'w':
				field[dogPosRow--][dogPosCol] = floor;
				break;
				
			case 's':
				field[dogPosRow++][dogPosCol] = floor;
				break;
				
			case 'q':
				isQuit = true;
				/* falls through */
			default:
				continue;
			}
			
			/* is Game Over: out of field*/
			if ((dogPosRow < 0 || dogPosRow >= height)
					|| (dogPosCol < 0 || dogPosCol >= width)) {
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
