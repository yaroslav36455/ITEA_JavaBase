package ua.itea.lesson8.tasks;

public class Bounds {
	private double min = Double.MIN_VALUE;
	private double max = Double.MAX_VALUE;
	
	public void set(double boundFirst, double boundSecond) {
		if(boundFirst < boundSecond) {
			min = boundFirst;
			max = boundSecond;
		} else {
			min = boundSecond;
			max = boundFirst;
		}
	}
	
	public boolean isWithin(double value) {
		return min < value && value < max;
	}
}
