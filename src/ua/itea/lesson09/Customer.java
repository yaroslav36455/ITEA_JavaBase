package ua.itea.lesson09;

public class Customer {
	private String name;
	private Basket basket;
	
	public Customer(String name) {
		this.name = name;
	}
	
	public void setBusket(Basket basket) {
		this.basket = basket;
	}
	
	public void addProduct(Product product) {
		if (basket != null) {
			basket.add(product);	
		}
	}
	
	public void removeProduct(String productName) {
		if (basket != null) {
			basket.remove(productName);
		}
	}
	
	public void showCard() {
		System.out.println("Name: " + name);
		if (basket != null) {
			basket.printInfo();
		} else {
			System.out.println("No basket");
		}
		System.out.println("--------------------------");
	}
	
	public Basket getBasket() {		
		Basket tmpBasket = basket;
		basket = null;
		return tmpBasket;
	}
}
