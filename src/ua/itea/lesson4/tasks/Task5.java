package ua.itea.lesson4.tasks;

public class Task5 {
	public static void main(String[] args) {
		int[] months = new int[12];
		for (int m = 1; m <= months.length; m++)
			months[m - 1] = (m >> 3) == (m & 1) ? (m == 2 ? 28 : 30) : 31;

		/* Output */
		for (int i = 0; i < months.length; i++)
			System.out.print(months[i] + " ");
		System.out.println();
	}
}
