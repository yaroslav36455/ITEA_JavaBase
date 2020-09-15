package ua.itea.lesson11;

public class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}

	@Override
	public void getVoice() {
		System.out.println("Wuf-Wuf");
	}
}
