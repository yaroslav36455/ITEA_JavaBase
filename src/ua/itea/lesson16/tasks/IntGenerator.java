package ua.itea.lesson16.tasks;

public class IntGenerator {
	ClosedIntRange range;
	
	public IntGenerator(ClosedIntRange range) {
		this.range = range;
	}
	
	public int generateExcept(int ...except) {
		int gen;
		
		do {
			gen = (int) (Math.random() * range.getSpan() + range.getLowerBound());
		} while(contains(except, gen));
		
		return gen;
	}
	
	private static boolean contains(int[] array, int value) {
		for (int i : array) {
			if (i == value) {
				return true;
			}
		}
		
		return false;
	}
}
