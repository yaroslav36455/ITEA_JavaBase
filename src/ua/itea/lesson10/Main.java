package ua.itea.lesson10;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Pudge pudge = new Pudge(1000, 24, 12, 60);
		
		pudge.getInfo();
		
		Item item = new Item("Sword", 4, 5, 2);
		pudge.addItem(item);
		pudge.getInfo();
		
		Item item2 = new Item("Gem of true sight", 7, 9, 13);
		pudge.addItem(item2);
		pudge.getInfo();
		
		
		Pudge pudge2 = new Pudge(920, 31, 16, 62);
		
//		while (pudge.getHealth() > 0 && pudge2.getHealth() > 0) {
//			pudge.setHealth(pudge.getHealth() - pudge2.getStrikePower());
//			if (pudge.getHealth() <= 0) {
//				break;
//			}
//			
//			pudge2.setHealth(pudge2.getHealth() - pudge.getStrikePower());
//			
//			
//			System.out.println("Pudge1 health: " + pudge.getHealth());
//			System.out.println("Pudge2 health: " + pudge2.getHealth());
//		}
//		
//		if (pudge.getHealth() > pudge2.getHealth()) {
//			System.out.println("Pudge1 won");
//		} else {
//			System.out.println("Pudge2 won");
//		}
		
		
		pudge.removeItem("Gem of true sight");
		pudge.getInfo();
		
		
		Dog dog = new Dog("Pudge");
		dog.printName();
		
		Dog dog2 = new Dog("Techies") {
			private int age = 15;
			
			public void printName() {
				System.out.println("Name: " + getName()
								   + "; Age: " + age);
			}
		};
		
		dog2.printName();
		
		
		Eurasia eurasia = new Eurasia() {
			public void print() {
				for (String country : getCountries()) {
					if (!country.equals("Russia")) {
						System.out.println(country);
					}
				}
			}
		};
		eurasia.print();
		
		System.out.println(Arrays.toString(DaysOfWeek.values()));
		System.out.println(DaysOfWeek.valueOf("MONDAY"));
		//System.out.println(DaysOfWeek.valueOf("MOND"));
		System.out.println(DaysOfWeek.TUESDAY.getField1());
		
		DaysOfWeek day = DaysOfWeek.valueOf("MONDAY");
		
		switch (day) {
		case MONDAY:
			System.out.println(day.getField1());
			break;

		default:
			break;
		}
	}
}
