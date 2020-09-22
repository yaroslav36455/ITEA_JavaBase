package ua.itea.lesson13;

public class DogStorrage {
	Dog[] dogStorrage = new Dog[3];
	
	public void add(Dog dog) {
//		try {
			//validateDog(dog);
			for (int i = 0; i < dogStorrage.length; i++) {
				if (dogStorrage[i] == null) {
					dogStorrage[i] = dog;
					break;
				}
				
			}
//		} catch (DogNotValidException e) {
//			System.out.println(e.getMessage());
//		}
	}
	
	public Dog find(String name) throws DogNotValidException {
		for (int i = 0; i < dogStorrage.length; i++) {
			if (dogStorrage[i] != null
					&& name.equals(dogStorrage[i].getName())) {
				Dog found = dogStorrage[i];
				validateDog(found);
				return found;
			}
		}
		
		throw new DogNotFoundException("Dog with name " + name + " not found");
	}
	
	public boolean validateDog(Dog dog) throws DogNotValidException{
		if (dog != null && dog.getName() != null
				&& dog.getName().length() >= 3) {
			return true;
		} else {
			throw new DogNotValidException("Dog with name " + dog.getName()
										   + " is not valid");
		}
	}
}
