/**
 * Print the most expensive beer available
 */
package ua.itea.lesson02;

/**
 * @author Tarasenko Yaroslav
 */
public class Pub {

	/**
	 * @param args ignored
	 */
	public static void main(String[] args) {
		int money = 58;
		int hoegaarden = 65;

		/* Sort by price */
		if (money >= hoegaarden) {
			System.out.println("Hoegaarden");
		} else if (money >= 55 && money < hoegaarden) {
			System.out.println("Leffe");
		} else if (money >= 45) {
			System.out.println("Stella Artua");
		} else if (money >= 30) {
			System.out.println("Chernigivske");
		} else if (money >= 7) {
			System.out.println("Obolon");
		} else {
			System.out.println("not enough money");
		}
	}
}
