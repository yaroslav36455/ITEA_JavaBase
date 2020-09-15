package ua.itea.lesson11;

public class Car {
	String mark = "Volvo";
	String model = "X1";
	String color = "Grey";
	double engineVolume = 3.4;
	
	public Car(String mark, String model, String color, double engineVolume) {
		this.mark = mark;
		this.model = model;
		this.color = color;
		this.engineVolume = engineVolume;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public void getInfo() {
		System.out.println("Mark: " + mark
						   + "; Model: " + model
						   + "; Color: " + color
						   + "; Engine Volume: " + engineVolume);
	}
}
