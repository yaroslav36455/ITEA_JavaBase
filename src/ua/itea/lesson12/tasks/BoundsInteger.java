package ua.itea.lesson12.tasks;

public class BoundsInteger {
	private int min = Integer.MIN_VALUE;
	private int max = Integer.MAX_VALUE;
	private boolean isIncludeMin = true;
	private boolean isIncludeMax = true;
	
	public void set(int boundFirst, int boundSecond) {
		if(boundFirst < boundSecond) {
			min = boundFirst;
			max = boundSecond;
		} else {
			min = boundSecond;
			max = boundFirst;
		}
	}
	
	public boolean isWithin(double value) {
		boolean lower   = isIncludeMin ? value < min : value <= min;
		boolean greater = isIncludeMax ? value > max : value >= max;
		return !(lower || greater);
	}
	
	public void include() {
		includeMin();
		includeMax();
	}
	
	public void includeMin() {
		isIncludeMin = true;
	}
	
	public void includeMax() {
		isIncludeMax = true;
	}
	
	public void exclude() {
		excludeMin();
		excludeMax();
	}
	
	public void excludeMin() {
		isIncludeMin = false;
	}
	
	public void excludeMax() {
		isIncludeMax = false;
	}
}
