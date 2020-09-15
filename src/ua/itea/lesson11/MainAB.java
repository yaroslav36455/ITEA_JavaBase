package ua.itea.lesson11;

public class MainAB {

	public static void main(String[] args) {
//		new C();

//		Employee employee = new Employee("Fred", 5000.0);
//		Boss boss = new Boss("Alice", 7000.0, 1000);
//		
//		employee.getInfo();
//		boss.getInfo();
		
		Hero hero = new Hero(1000, 20, 32, 18);
		Pudge pudge = new Pudge(1200, 13, 9, 41);
		CrystalMaiden cm = new CrystalMaiden(900, 15, 31, 6);
		
		hero.getInfo();
		pudge.getInfo();
		cm.getInfo();
		
		
//		Parent parent = new Parent();
//		Child child = new Child();
		
		Parent parent = new Child();
		Child child = (Child) parent;
		System.out.println(parent.name);
		
		System.out.println(child.name);
		
		Animal animal = new Animal("Boba");
		Cat cat = new Cat("Rabbit");
		
		animal.getVoice();
		cat.getVoice();
		
		Animal a = new Cat("CatName");
		a.getVoice();
		
		Animal b = new Dog("Frank");
		b.getVoice();
	}

}
