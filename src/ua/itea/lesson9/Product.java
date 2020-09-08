package ua.itea.lesson9;

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
	
	public void getInfo() {
		System.out.println("Name: " + name + "; Price: " + price);
	}
}
