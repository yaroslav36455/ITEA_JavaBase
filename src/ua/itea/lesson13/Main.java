package ua.itea.lesson13;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
//		Smartphone smartphone = new Smartphone(2.3, "Model1");
//		Smartphone cloned = (Smartphone) smartphone.clone();
//		
//		System.out.println(smartphone);
//		System.out.println(cloned);
//		
//		smartphone.model = "B";
//		
//		System.out.println(smartphone);
//		System.out.println(cloned);
		
		Owner owner = new Owner("Bob");
		Dog dog = new Dog();
		
		dog.setOwner(owner);
		System.out.println(dog);
		
		
		
	}

}
