package ua.itea.lesson12;

public class ColoredWeightProduct extends ColoredProduct {
	private double weight;
	
	public ColoredWeightProduct(String name, int price, String color,
								double weight) {
		super(name, price, color);
		this.weight = weight;
	}
	
	@Override
	public String getInfo() {
		return super.getInfo() + "; Weight: " + weight;
	}
}
