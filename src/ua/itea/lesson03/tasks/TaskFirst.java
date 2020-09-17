/**
 * 
 */
package ua.itea.lesson03.tasks;

/**
 * @author Tarasenko Yaroslav
 */
public class TaskFirst {

	/**
	 * @param args ignored
	 */
	public static void main(String[] args) {
		
		/* Negative money is not allowed */
		double money = 455.85;
		int discount;
  
		/* Sort by money */
		if (money >= 500) {
			discount = 7;
		} else if (money >= 400) {
			discount = 5;
		} else if (money >= 300) {
			discount = 3;
		} else {
			discount = 0;
		}
		
		System.out.printf("Ваша скидка %d%%, "
				           + "и того к оплате %.2f с учётом скидки.",
				           discount,
				           money * (1. - discount / 100.));
	}
}
