package ua.itea.lesson11;

public class Main {

	public static void main(String[] args) {
		Car car = new Car("Tesla", "Y", "White", 5);
		Car car2 = new Car("Ford", "Pg", "Black", 4.3);
		car.setColor("Red");
		
		car.getInfo();
		car2.getInfo();
		
		
		BMW bmw = new BMW();
		bmw.getInfo();
	}

}
