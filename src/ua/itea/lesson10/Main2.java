package ua.itea.lesson10;

import ua.itea.lesson10.Outer.Inner;

public class Main2 {

	public static void main(String[] args) {
		
//		Inner inner = new Outer().new Inner();
//		String str = inner.innerPublic;
//		
//
//		Car car1 = new Car();
//		car1.setColor("Grey");
//		
//		Car car2 = new Car();
//		car2.setColor("Black");
//		
//		car1.getInfo();
//		car2.getInfo();
//		
//		System.out.println(Car.color);
//		System.out.println(Car.getMark());
//		
//		System.out.println(Outer.Nested.nestedField);
		
		ElectricGuitar eg = new ElectricGuitar("Some music");
		eg.play();
	}

}
