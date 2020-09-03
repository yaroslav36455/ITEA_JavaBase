package ua.itea.lesson8;

import java.util.Scanner;

public class Main {

	public static void main(String ...args) {
//		PowerSupply ps = new PowerSupply();
//		
//		ps.printInfo();
//		
//		ps.setInputVoltage(199);
//		ps.printInfo();
//		
//		ps.setInputVoltage(200);
//		ps.printInfo();
//		
//		ps.setInputVoltage(250);
//		ps.printInfo();
//		
//		ps.setInputVoltage(251);
//		ps.printInfo();
		
		Scanner scanner = new Scanner(System.in);
		
		Lamp lamp = new Lamp();
		lamp.printInfo();
		
//		lamp.setBrightness(5);
//		lamp.printInfo();
//		
//		lamp.setBrightness(34);
//		lamp.printInfo();
//		
//		lamp.setBrightness(495);
//		lamp.printInfo();
//		
//		lamp.setBrightness(0);
//		lamp.printInfo();
		
//		while (scanner.hasNext()) {
//		if (scanner.hasNextInt()) {
//			lamp.setBrightness(scanner.nextInt());
//			lamp.printInfo();	
//		} else {
//			System.out.println("Вы должны ввести число!");
//			scanner.next();
//		}
//	}
		
		lamp.doSomething();
		lamp.doSomething(6.0);
		lamp.doSomething(6);
		lamp.doSomething(8.34, -1);
		lamp.doSomething(8, -1.43);
		
		//lamp.doSomethingElse(new int[]{ 34, 4, 34, -845 });
		lamp.doSomethingElse(1, 2 , 3);
		
		int a = lamp.getA();
		System.out.println(a);
		
		scanner.close();
	}

}
