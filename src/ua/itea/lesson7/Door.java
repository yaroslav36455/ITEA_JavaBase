package ua.itea.lesson7;

public class Door {
	boolean isOpen;
	String material = "wooden";
	String color = "black";
	
	public void open() {
		isOpen = true;
	}
	
	public void close() {
		isOpen = false;
	}
	
	public void printInfo() {
		System.out.println("State: " + ((isOpen) ? "opened" : "closed")
					       + "; Material: " + material
					       + "; Color: " + color + ".");
	}
}
