/**
 * 
 */
package ua.itea.lesson3.tasks;

/**
 * @author Tarasenko Yaroslav
 */
public class TaskFirst {

	/**
	 * @param args ignored
	 */
	public static void main(String[] args) {
		
		/* Negative money is not allowed */
		float money = 455.85f;
		float discount;
  
		/* Sort by money */
		if (money >= 500) {
			discount = 0.07f;
		} else if (money >= 400) {
			discount = 0.05f;
		} else if (money >= 300) {
			discount = 0.03f;
		} else {
			discount = 0.0f;
		}
		
		System.out.println("Ваша скидка " + discount + "%, "
				           + "и того к оплате " + money * (1. - discount)
				           + " с учётом скидки.");
	}
}
