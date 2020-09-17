package ua.itea.lesson06;

//import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
//		int[][] arr = new int[3][3];
//		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				arr[i][j] = (int) (Math.random() * Integer.MAX_VALUE);
//			}
//		}
//		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//		
//		char[][] arr2 = new char[9][9];
//		for (int i = 0; i < arr2.length; i++) {
//			for (int j = 0; j < arr2[i].length; j++) {
//				if ((i == 0 || i == arr2.length - 1)
//						||(j == 0 || j == arr2[i].length - 1)
//						||(i == arr2.length / 2) && (j == arr2[i].length / 2)) {
//					arr2[i][j] = '*';
//				} else {
//					arr2[i][j] = ' ';
//				}
//			}
//		}
//		
//		for (int i = 0; i < arr2.length; i++) {
//			for (int j = 0; j < arr2[i].length; j++) {
//				System.out.print(arr2[i][j]);
//			}
//			System.out.println();
//		}
		
		/***********************************************************************/
//		int[][] arr = new int[4][];
//		arr[0] = new int[4];
//		int[] a = {1, 56, -45, 0};
//		arr[1] = a;
		/***********************************************************************/
		
//		int[][] arr = new int[5][100];
//		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				arr[i][j] = (int) (Math.random() * 100);
//			}
//		}
//		
//		for (int z = 0; z < arr.length; z++) {
//			for (int k = 0; k < arr[z].length; k++) {
//				boolean exit = true;
//				for (int i = 0; i < arr[z].length - 1 - k; i++) {
//					if (arr[z][i] > arr[z][i + 1]) {
//						int tmp = arr[z][i];
//						arr[z][i] = arr[z][i + 1];
//						arr[z][i + 1] = tmp;
//						exit = false;
//						}
//					}
//				if(exit) {
//					break;
//					}
//				}
//		}
//		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		/***********************************************************************/
		
		
		String url = "https://ukr.net/sport/news.jsp";
		
		int i = url.indexOf(":");
		System.out.println(i);
		
		String p = url.substring(0, i);
		System.out.println("Protocol:" + p);
		
		url = url.substring(i + 3);
		System.out.println(url);
		
		i = url.indexOf("/");
		System.out.println(i);
		
		String d = url.substring(0, i);
		System.out.println("Domain:  " + d);
		
		System.out.println("Path:    " + url.substring(i));
		
		
		String fio = "yacenuk     arseniy  petrovich";
		/* Yanukovich V. F.*/
		
		int space1 = fio.indexOf(" ");
		String name1 = fio.substring(0, space1);
		name1 = name1.substring(0, 1).toUpperCase() + name1.substring(1);
		System.out.println(name1);
		
		int space2 = fio.lastIndexOf(" ");
		String name2 = fio.substring(space1, space2).trim().substring(0, 1).toUpperCase();
		System.out.println(name2);
		
		String name3 = fio.substring(space2).trim().substring(0, 1).toUpperCase();
		System.out.println(name3);
		
		System.out.println(name1 + ' ' + name2 + ". " + name3 + ".");
		
		
		/* 1.
		 * Собака ходит по двумерному массиву 10х10
		 * Добавляются клавиши w и s
		 * Аптечка и бомбочка генерируются в каждом массиве
		 * Сделать обработку клавиш через switch
		 *
		 * 2.
		 * Массив типа String 3х3
		 * Заполняется через Scanner с клавиатуры через ввод трёх строк
		 * Программа делает поисковый запрос
		 * 
		 * 3.
		 * Со Scanner вводится две строки
		 * Определить:
		 *  1.Какая строка длиннее
		 *  2.В какой строке больше слов
		 *  3.В какой строке больше согласных
		 *  */
	}

}
