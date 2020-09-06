package ua.itea.lesson8.tasks;

public class BoundsInteger {
	private int min = Integer.MIN_VALUE;
	private int max = Integer.MAX_VALUE;
	
	public void set(int boundFirst, int boundSecond) {
		if(boundFirst < boundSecond) {
			min = boundFirst;
			max = boundSecond;
		} else {
			min = boundSecond;
			max = boundFirst;
		}
	}
	
	public boolean isWithin(int value) {
		return !(value < min || max < value);
	}
}
