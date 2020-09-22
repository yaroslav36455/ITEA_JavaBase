package ua.itea.lesson13;

public class Main2 {

	public static void main(String[] args) {
//		System.out.println("start");
//		
//		int[] arr = null;
//		try {
//			System.out.println(arr[3]);
//		} catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println(e.getMessage());
//		} catch (NullPointerException e) {
//			System.out.println(e.getMessage());
//		} catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		Dog dog = new Dog();
//		try {
//			dog.someMethod();
//		} catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			Dog dog2 = (Dog) dog.clone();
//		} catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println("end");
		
		DogStorrage dogStorrage = new DogStorrage();
		dogStorrage.add(new Dog("Bi", 4));
		dogStorrage.add(new Dog("Barsik", 12));
	
		
		try {
			Dog found = dogStorrage.find("Suslik");
			System.out.println(found);
		} catch (DogNotValidException e) {
			System.out.println(e.getMessage());
//			dogStorrage.find("STrst");
//			throw new Exception();
		} catch (DogNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("Finally");
		}
		
		Dog found2 = null;
		try {
			found2 = dogStorrage.find("Some name");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(found2);
	}

}
