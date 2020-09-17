package ua.itea.lesson04.tasks;

import java.util.Arrays;

public class Task1 {
	public static void main(String[] args) {
		int size = 10;
		byte[]  arrayByte  = new byte[size];
		short[] arrayShort = new short[size];
		int[]   arrayInt   = new int[size];
		int arrayByteIter  = 0;
		int arrayShortIter = 0;
		int arrayIntIter   = 0;
		long counter = 0;
		
		while (arrayByteIter  < size ||
				   arrayShortIter < size ||
				   arrayIntIter   < size) {
			
			/* Only non negative random values allowed */
			int random = (int) (Math.random() * (Integer.MAX_VALUE + 1L));

			if (random <= Byte.MAX_VALUE && arrayByteIter < size) {
				arrayByte[arrayByteIter++] = (byte) random;	
			} else if (random <= Short.MAX_VALUE && arrayShortIter < size) {
				arrayShort[arrayShortIter++] = (short) random;
			} else if (arrayIntIter < size) {
				arrayInt[arrayIntIter++] = random;
			}
			
			counter++;
		}

		/* Output */
		System.out.println("Number of iterations: " + counter);
		System.out.println(Arrays.toString(arrayByte));
		System.out.println(Arrays.toString(arrayShort));
		System.out.println(Arrays.toString(arrayInt));
	}
}
