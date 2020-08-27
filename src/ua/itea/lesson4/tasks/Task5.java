package ua.itea.lesson4.tasks;

import java.util.Arrays;

public class Task5 {
	public static void main(String[] args) {
		int[] months = new int[12];
		for (int m = 1; m <= months.length; m++)
			months[m - 1] = (m >> 3) == (m & 1) ? (m == 2 ? 28 : 30) : 31;

		/* Output */
		System.out.println(Arrays.toString(months));
	}
}
