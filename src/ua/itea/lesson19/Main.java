package ua.itea.lesson19;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Dog dog1 = new Dog("A", 3);
		Dog dog2 = new Dog("B", 1);
		Dog dog3 = new Dog("C", 5);
		
		TreeSet<Dog> dogs = new TreeSet<>(new DogComparator());
		
		dogs.add(dog1);
		dogs.add(dog2);
		dogs.add(dog3);
		
		System.out.println(dogs);
		
		Iterator<Dog> iter = dogs.iterator();
		
		while (iter.hasNext()) {
			Dog dog = iter.next();
			if ((dog.getAge() % 3) == 0) {
				iter.remove();
			}
		}
		
//		for (Dog dog : dogs) {
//			if ((dog.getAge() % 3) == 0) {
//				//dogs.remove(dog);
//			}
//			//dog.setName(dog.getName() + 1);
//			//System.out.println(dog);
//		}
		
		System.out.println(dogs);
		
		int[] arr = {1, 2, 3};
		
		for (int i : arr) {
			i += 1;
		}
		
		System.out.println(Arrays.toString(arr));
		
		Map<String, Dog> dogMap = new HashMap<>();
		
		dogMap.put("one", dog1);
		dogMap.put("two", dog2);
		dogMap.put("three", dog3);
		
		System.out.println(dogMap);
		
		// 1
		Set<String> keySet = dogMap.keySet();
		for (String key : keySet) {
			System.out.println(key + "=" + dogMap.get(key));
		}
		
		// 2
		for (Map.Entry<String, Dog> dogEntry : dogMap.entrySet()) {
			System.out.println(dogEntry.getKey() + "=" + dogEntry.getValue());
		}
		
		// 3
		Iterator<String> iter3 = dogMap.keySet().iterator();
		while(iter3.hasNext()) {
			System.out.println(dogMap.get(iter3.next()));
		}
		
		////
		Cat cat1 = new Cat("CatA", 3);
		Cat cat2 = new Cat("CatB", 45);
		Cat cat3 = new Cat("CatC", 2);
		
		Map<Cat, Dog> catDogMap = new HashMap<>();
		
		catDogMap.put(cat1, dog1);
		catDogMap.put(cat2, dog2);
		catDogMap.put(cat3, dog3);
		
		Cat newCat2 = new Cat("CatB", 45);
		System.out.println();
		System.out.println(catDogMap.get(newCat2));
	}

}
