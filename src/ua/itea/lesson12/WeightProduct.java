package ua.itea.lesson12;

public class WeightProduct extends Product {
	private double weight;
	
	public WeightProduct(String name, int price, double weight) {
		super(name, price);
		this.weight = weight;
	}
	
	@Override
	public String getInfo() {
		return super.getInfo() + "; Weight: " + weight;
	}
}
