package ua.itea.lesson8.tasks;

public class BoundsDouble {
	private double min = Double.NEGATIVE_INFINITY;
	private double max = Double.POSITIVE_INFINITY;
	private boolean isIncludeMin = true;
	private boolean isIncludeMax = true;
	
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
