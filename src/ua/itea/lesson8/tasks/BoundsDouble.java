package ua.itea.lesson8.tasks;

public class BoundsDouble {
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
		return !(value < min || max < value);
	}
}
