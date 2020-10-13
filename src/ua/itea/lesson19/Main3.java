package ua.itea.lesson19;

public class Main3 {

	public static void main(String[] args) {
		OwnArrayList dogs = new OwnArrayList();
		
		Dog dog1 = new Dog("A", 3);
		Dog dog2 = new Dog("B", 5);
		dogs.add(dog1);
		dogs.add(dog2);
		System.out.println(dogs);
		
		Dog dog3 = new Dog("C", 8);
		Dog dog4 = new Dog("D", 7);
		dogs.add(dog3);
		dogs.add(0, dog4);
		System.out.println(dogs);
		
		dogs.remove(new Dog("C", 8));
		//dogs.remove(new Dog("B", 5));
		System.out.println(dogs);
	}

}
