package ua.itea.lesson7;

import java.util.Arrays;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
//		System.out.printf(" fp %10s  fpwth %6s %05d\n", "Text!", "Text2!", 99);
//		System.out.printf("%7.2f\n", Math.PI);
//		
//		System.out.printf("|%-1s|%-15s|%-7s|\n", "№", "Currency", "Rate");
//		System.out.printf("|%-1s|%-15s|%-7s|\n", "1", "American dollar", "27.4");
//		System.out.printf("|%-1s|%-15s|%-7s|\n", "2", "Euro", "32.5");
//		System.out.printf("|%-1s|%-15s|%-7s|\n", "3", "Russian", "999.999");
		
		//System.out.printf("%tT", new Date());
//		Date day = new Date();
//		System.out.printf("Today is %1$ta weekday, year %1$tY, %1$tB month, %1$td day; time: %1$tH hours, %1$tM minutes, %1$tS seconds", day);
		
		String str = "";
		for (int i = 0; i < 100; i++) {
			str += i;
		}
		System.out.println(str);
		
		StringBuilder sb = new StringBuilder();
		System.out.println("l:" + sb.length());
		System.out.println("c:" + sb.capacity());
		sb.append("12345678901234567");
		System.out.println("l:" + sb.length());
		System.out.println("c:" + sb.capacity());
		
		sb = new StringBuilder();
		int oldCapacity =  sb.capacity();
		int counter = 0;
		for (int i = 0; i < 100; i++) {
			sb.append(i);
			int capacity = sb.capacity();
			if (oldCapacity != capacity) {
				oldCapacity = capacity;
				System.out.println("New capacity:" + capacity);
				System.out.println("counter: " + ++counter);
			}
		}
		
		sb.trimToSize();
		System.out.println("l:" + sb.capacity());
		System.out.println("c:" + sb.length());
		
		
		StringBuilder sb2 = new StringBuilder("123345");
		System.out.println("sb2: " + sb2.toString());
		sb2.append("123", 0, 1);
		sb2.insert(3, "000", 0, 3);
		//sb2.append(str, offset, len)
		System.out.println("sb2: " + sb2.toString());
		
		
		String words = "one two three";
		String[] wa = words.split(" ");
		System.out.println(Arrays.toString(wa));
	}

}
