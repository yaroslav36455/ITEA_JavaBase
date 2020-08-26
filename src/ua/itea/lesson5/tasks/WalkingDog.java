package ua.itea.lesson5.tasks;

import java.util.Arrays;
import java.util.Scanner;

public class WalkingDog {

	public static void main(String[] args) throws InterruptedException {
		boolean isGameOver = false;
		boolean isQuit = false;
		Scanner scanner = new Scanner(System.in);
		
		char[] field = new char[10];
		int dogPos = 0;
		char floor = '_';
		char dog   = '@';
		
		char buttonPressed;
		char leftButton  = 'a';
		char rightButton = 'd';
		char quitButton  = 'q';
		
		Arrays.fill(field, floor);
		System.out.println("Control:");
		System.out.println(" left  - '" + leftButton  + "';");
		System.out.println(" right - '" + rightButton + "';");
		System.out.println(" quit  - '" + quitButton  + "'.");
		
		while(!isQuit) {
			
			/* Draw */
			field[dogPos] = dog;
			System.out.print("\r[");
			for (int i = 0; i < field.length; i++) {
				System.out.print(field[i]);
			}
			System.out.print("]");
			
			/* Request next direction */
			System.out.print(" | Press: ");
			buttonPressed = scanner.next().charAt(0);
			
			/* Handle key press */
			if (buttonPressed == quitButton) {
				isQuit = true;
			} else if (buttonPressed == leftButton) {
				field[dogPos--] = floor;
			} else if (buttonPressed == rightButton) {
				field[dogPos++] = floor;
			}
			
			/* is Game Over */
			if (dogPos < 0 || dogPos >= field.length) {
				isGameOver = true;
				isQuit = true;
			}	
		}
		
		scanner.close();
		if (isGameOver)
			System.out.println("Game Over");
		System.out.println("Quit");
	}

}
