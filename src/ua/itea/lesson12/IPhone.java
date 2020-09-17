package ua.itea.lesson12;

public class IPhone extends Smartphone {
	private String os = "IOS";

	public IPhone(double screenSize, String model, String os) {
		super(screenSize, model);
		this.os = os;
	}
	
	@Override
	public void getInfo() {
		super.getInfo();
		System.out.println("OS: " + os);
	}
}
