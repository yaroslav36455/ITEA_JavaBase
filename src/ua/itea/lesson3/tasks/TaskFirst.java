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
		double money = 455.85;
		double discount;
  
		/* Sort by money */
		if (money >= 500) {
			discount = 0.07;
		} else if (money >= 400) {
			discount = 0.05;
		} else if (money >= 300) {
			discount = 0.03;
		} else {
			discount = 0.0;
		}
		
		System.out.printf("Ваша скидка %.2f%%, "
				           + "и того к оплате %.2f с учётом скидки.",
				           discount, money * (1. - discount));
	}
}
