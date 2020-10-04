package ua.itea.lesson16.tasks;

public class ClosedIntRange {
	private int lowerBound;
	private int upperBound;
	
	public ClosedIntRange(int boundFirst, int boundSecond) {
		if (boundFirst < boundSecond) {
			lowerBound = boundFirst;
			upperBound = boundSecond;
		} else {
			lowerBound = boundSecond;
			upperBound = boundFirst;
		}
	}
	
	public boolean isWithin(int value) {
		return !(value < lowerBound || value > upperBound);
	}
	
	public int getSpan() {
		return (upperBound - lowerBound) + 1;
	}
	
	public int getLowerBound() {
		return lowerBound;
	}
	
	public int getUpperBound() {
		return upperBound;
	}
	
	public boolean isIncludeLowerBound() {
		return true;
	}
	
	public boolean isIncludeUpperBound() {
		return true;
	}
}
