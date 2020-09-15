package ua.itea.lesson11;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}
	
	@Override
	public void getVoice() {
		System.out.println("Miu-Miu");
	}
}
