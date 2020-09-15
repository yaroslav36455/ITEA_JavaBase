package ua.itea.lesson11;

public class BMW extends Car {
	private int doors;

	public BMW() {
		super("Cherry", "qq", "Red", 0.9);
//		mark = "BMW";
//		model = "GJ-32";
//		color = "Black";
//		engineVolume = 3.7;
		doors = 2;
	}
	
	@Override
	public void getInfo() {
		System.out.println("Mark: " + mark
						   + "; Model: " + model
						   + "; Color: " + color
						   + "; Engine Volume: " + engineVolume
						   + "; Doors: " + doors);
	}
}
