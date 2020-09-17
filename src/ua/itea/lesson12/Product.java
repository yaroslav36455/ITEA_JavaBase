package ua.itea.lesson12;

public class Product {
	private String name;
	private int price;
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getInfo() {
		return "Name: " + name + "; Price: " + price;
	}
}
