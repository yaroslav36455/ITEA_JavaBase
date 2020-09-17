package ua.itea.lesson07;

public class DoorMain {

	public static void main(String[] args) {
		Door door = new Door();
		door.printInfo();
		
		door.open();
		door.printInfo();
		
		door.close();
		door.printInfo();
	}

}
