package ua.itea.lesson5;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
//		//int[] arr = new int[100];
//		int[] arr = {0, 1, 1, 5, 8, 9, 10, 10, 10, 11, 12, 13, 13, 15, 16, 16, 17, 17, 17, 17, 17, 19, 19, 19, 22, 22, 23, 26, 27, 29, 29, 30, 31, 31, 31, 32, 33, 34, 35, 35, 36, 37, 38, 41, 41, 42, 42, 45, 46, 47, 50, 50, 55, 61, 61, 61, 61, 62, 63, 64, 66, 68, 68, 70, 70, 71, 71, 72, 73, 75, 76, 76, 77, 78, 79, 81, 83, 83, 84, 84, 86, 88, 88, 89, 90, 91, 91, 91, 91, 92, 92, 92, 93, 95, 95, 95, 96, 97, 98, 97};
////		for (int i = 0; i < arr.length; i++) {
////			arr[i] = (int) (Math.random() * 100);
////		}
//		
//		System.out.println(Arrays.toString(arr));
//		
//		int counter = 0;
//		for (int k = 0; k < arr.length; k++) {
//			boolean exit = true;
//			for (int i = 0; i < arr.length - 1 - k; i++) {
//				if (arr[i] > arr[i + 1]) {
//					int tmp = arr[i];
//					arr[i] = arr[i + 1];
//					arr[i + 1] = tmp;
//					exit = false;
//				}
//				counter++;
//			}
//			if(exit) {
//				break;
//			}
//		}
//		
//		System.out.println(Arrays.toString(arr));
//		System.out.println(counter);
		
		int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] b = new int[3];
//		for (int i = 0; i < b.length; i++) {
//			b[i] = a[i];
//		}
		
		
//		System.out.println(a);
//		System.out.println(b);
//		b = a;
		System.out.println(a);
		System.out.println(b);
		System.out.println(Arrays.toString(a));
		
		System.arraycopy(b, 0, a, 3, b.length);
		System.out.println(Arrays.toString(a));
		/* Массив char 10 элементов заполнен символом нижнего подчеркивания
		 * На первой позиции стоит символ '@'
		 * При вводе через Scanner клавиши d собачка сдвигается вправо на одну ячейку
		 * При a - влево
		 * Game Over - собака дошла до конца массива
		 * 
		 * Дополнительно
		 * У собаки есть 100 ед. здоровья
		 * За каждый шаг она теряет 5 единиц
		 * Game Over - здоровье меньше 0
		 * 
		 * На поле рандомно появляется бомбочка(знак '*') и аптечка(знак '+')
		 * Это -40 здоровья и +40 здоровья соответственно
		 * */
	}

}
