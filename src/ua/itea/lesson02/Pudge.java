package ua.itea.lesson02;

public class Pudge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a = -5;
//		int b = -10;
//		int c = 0;
//		
//		if ((a > 0 | b > 0) & c == 0) {
//			System.out.println("ok!");
//		}
//		System.out.println(c);
//		if (a > 0) {
//			b = 10;
//		} else {
//			b = -10;
//		}
//		b = a > 0 ?  10 : -10;
//		System.out.println(a > 0 ? "yes" : "no");
//		int t = 20;
//		if (t < 0) {
//			System.out.println("ice");
//		} else {
//			if (t < 100) {
//				System.out.println("water");
//			} else {
//				System.out.println("steam");
//			}
////			System.out.println(t < 100 ? "water" : "steam");
////			System.out.println("water");
//			
//		}
//		
//		System.out.println(t < 0 ? "ice" : (t < 100 ? "water" : "steam"));
//		
//		int f = 10;
//		switch (f) {
//		case 0:
//			System.out.println("zero");
//			break;
//		case 1:
//			System.out.println("one");
//			break;
//		case 2:
//			System.out.println("two");
//			break;
//		default:
//			System.out.println("unknown");
//			break;
//		}
//		
//		if (f == 0) {
//			System.out.println("zero");
//		} else if (f == 1) {
//			System.out.println("one");
//		} else if (f == 2) {
//			System.out.println("two");
//		} else {
//			System.out.println("unknown");
//		}
		int i;
		for (i = 0; i < 5; i++) {
			
			System.out.println(i);
			
		}
		System.out.println("------------------------------");
		
		i = 5;
		while (i < 5) {
			System.out.println(i++);
		}
		System.out.println("------------------------------");
		
		i = 5;
		do {
			System.out.println(i++);
		} while (i < 5);
		
		int someNumber = 123;
		//someNumber -= someNumber % 10;
		System.out.println(someNumber % 10);
		
		int iter = 0;
		while (someNumber > 0) {
			iter++;
			someNumber /= 10;
		}
		System.out.println(iter);
	}

}
