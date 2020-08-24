package ua.itea.lesson4.tasks;

public class Task4 {
	public static void main(String[] args) {
		/* Randomize array length */
		int rangeLowerBound = 7;      // include
		int rangeUpperBound = 15 + 1; // exclude
		int range = rangeUpperBound - rangeLowerBound;
		int offset = rangeLowerBound;
		int[] array = new int[(int) (Math.random() * range + offset)];

		/* Randomize array elements */
		rangeLowerBound = 0;       // include
		rangeUpperBound = 100 + 1; // exclude
		range = rangeUpperBound - rangeLowerBound;
		offset = rangeLowerBound;
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * range + offset);
		}

		/* Output */
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
