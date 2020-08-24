/**
 * 
 */
package ua.itea.lesson3.tasks;

/**
 * @author Tarasenko Yaroslav
 *
 */
public class TaskSecond {

	/**
	 * @param args ignored
	 */
	public static void main(String[] args) {
		
		/* Negative money is not allowed */
		float money = 455.85f;
		float discount;
		int hundreds = ((int) money) / 100;
		
		switch (hundreds) {
		case 0:
		case 1:
		case 2:
			discount = 0.0f;
			break;
		case 3:
			discount = 0.03f;
			break;
		case 4:
			discount = 0.05f;
			break;
			
		default:
			discount = 0.07f;
			break;
		}
		
		System.out.println("Ваша скидка " + discount + "%, "
		           		   + "и того к оплате " + money * (1. - discount)
		           		   + " с учётом скидки.");
	}

}
