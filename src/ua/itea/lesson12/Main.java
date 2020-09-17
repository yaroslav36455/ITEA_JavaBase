package ua.itea.lesson12;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
//		Smartphone smartphone = new Smartphone(5.3, "Galaxy");
//		Samsung samsung = new Samsung(4.3, "GJJ");
//		
////		smartphone.getInfo();
////		samsung.getInfo();
//		
//		Samsung smartphone2 = new Samsung(4.3, "GJJ");
		Smartphone smartphone3 = new IPhone(5.4, "X", "IOS");
//		
//		smartphone2.getInfo();
//		System.out.println();
//		smartphone3.getInfo();
//		
//		
//		
//		Samsung s = (Samsung) smartphone2;
//		
//		
//		Product product = new Product("Apple", 2);
//		Product product2 = new ColoredProduct("Smartphone", 4000, "Grey");
//		Product product3 = new WeightProduct("Oranges", 45, 1.4);
//		Product product4 = new ColoredWeightProduct("Bread", 15, "Black", 1.4);
//		System.out.println(samsung.equals(product4));
//		ColoredProduct cp = new ColoredWeightProduct("Bread", 15, "Black", 1.4);
//		Object obj = new ColoredWeightProduct("Bread", 15, "Black", 1.4);
//		
//		ColoredWeightProduct cwp = (ColoredWeightProduct) obj;
//		
//		Basket basket = new Basket();
//		basket.add(product);
//		basket.add(product2);
//		basket.add(product3);
//		basket.add(product4);
//		
//		basket.printInfo();
		
//		Object object = smartphone3;
//		System.out.println(object.toString());
		
		Smartphone smartphone = new Smartphone(5.3, "Galaxy");
		Smartphone object2 = (Smartphone) smartphone.clone();
		System.out.println(object2.toString());
		smartphone.model = "IPhone";
		System.out.println(smartphone);
		System.out.println(object2);
	}

}
