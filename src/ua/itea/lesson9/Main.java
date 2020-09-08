package ua.itea.lesson9;

public class Main {
	public static void main(String[] args) {
//		Dog dog = new Dog();
////		
////		String name = dog.getName();
////		System.out.println(name);
////		
////		Cat cat = new Cat();
////		cat.setName(dog.getName());
//		
//		dog.getInfo();
//		
////		dog.setName("Barsik");
////		dog.setAge(12);
////		dog.getInfo();
//		
//		Dog dog2 = new Dog("Barsik", 8);
////		dog2.getInfo();
//		
//		Owner owner = new Owner("Bob");
//		dog2.setOwner(owner);
//		dog2.getInfo();
		
		
		Basket basket = new Basket();
		basket.printInfo();
		System.out.println("---------------------------");
		
		Product product1 = new Product("Soap", 4);
		Product product2 = new Product("Candy", 22);
		Product product3 = new Product("Bread", 3);
		
		basket.add(product1);
		basket.printInfo();
		System.out.println("---------------------------");
		
		basket.add(product2);
		basket.printInfo();
		System.out.println("---------------------------");
		
		basket.add(product3);
		basket.printInfo();
		System.out.println("---------------------------");
		
		basket.remove("Candy");
		basket.printInfo();
		System.out.println("---------------------------");
		
		
		Customer customer = new Customer("Bob");
		customer.setBusket(basket);
		customer.showCard();
		
		customer.addProduct(product3);
		customer.showCard();
		
		Customer customer2 = new Customer("George");
		customer2.showCard();
		
		customer2.setBusket(customer.getBasket());
		customer.showCard();
		customer2.showCard();
		
		Item item = new Item("Sword", 45, 4, 76);
		Pudge pudge = new Pudge();
		pudge.getInfo();
		
		pudge.addItem(item);
		pudge.getInfo();
	}
}
