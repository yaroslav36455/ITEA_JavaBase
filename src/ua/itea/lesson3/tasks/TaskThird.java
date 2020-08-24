/**
 * 
 */
package ua.itea.lesson3.tasks;

/**
 * @author Tarasenko Yaroslav
 */
public class TaskThird {

	/**
	 * @param args ignored
	 */
	public static void main(String[] args) {
		int initNumber = 94358;
		int number;
		int sumOfDigits = 0;
		int sumOfDigitsOdd = 0;
		
		System.out.println("Number: " + initNumber);
		
		/* Calculate and print the sum of digits of the number */
		number = initNumber;
		while (number > 0) {
			sumOfDigits += number % 10;
			number /= 10;
		}
		System.out.println("Sum of digits: " + sumOfDigits);
		
		/* Calculate and print the sum of odd digits of the number */
		number = initNumber;
		while (number > 0) {
			int endian = number % 10;
			sumOfDigitsOdd += (endian % 2) == 1 ? endian : 0;
			number /= 10;
		}
		System.out.println("Sum of odd digits: " + sumOfDigitsOdd);
	}

}
