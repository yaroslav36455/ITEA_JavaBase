package ua.itea.lesson13.tasks;

import java.math.BigDecimal;
import java.math.MathContext;

public class RangeDouble {
	private double min = Double.NEGATIVE_INFINITY;
	private double max = Double.POSITIVE_INFINITY;
	private boolean isIncludeMin = true;
	private boolean isIncludeMax = true;
	
	public void set(double boundFirst, double boundSecond) {
		boundFirst  = round(boundFirst);
		boundSecond = round(boundSecond);
		
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
	
	public boolean isIncludeMin() {
		return isIncludeMin;
	}
	
	public boolean isIncludeMax() {
		return isIncludeMax;
	}
	
	public double getMin() {
		return min;
	}
	
	public double getMax() {
		return max;
	}
	
	private double round(double d) {
		BigDecimal value = BigDecimal.valueOf(d);
		BigDecimal zero = BigDecimal.valueOf(0);
		
		return value.subtract(zero, new MathContext(15)).doubleValue();
	}
}
