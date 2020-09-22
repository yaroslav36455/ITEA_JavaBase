package ua.itea.lesson13;

public class DogNotFoundException extends IllegalArgumentException {

	public DogNotFoundException(String message) {
		super(message);
	}
}
