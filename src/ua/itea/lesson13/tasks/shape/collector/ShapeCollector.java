package ua.itea.lesson13.tasks.shape.collector;

import ua.itea.lesson13.tasks.ShapeContainer;
import ua.itea.lesson13.tasks.shape.Shape;

public class ShapeCollector extends ShapeContainer {
	private int limit;
	
	public ShapeCollector(int maxShapes) {
		super(maxShapes);
		this.limit = maxShapes;
	}
	
	public int limit() {
		return limit;
	}
	
	public boolean isFull() {
		return !(size() < limit());
	}
	
	public void addShape() {
		if (!isFull()) {
			add(createClonnedShape());
		} else {
			System.out.println("These shapes are enough");
		}
	}
	
	protected Shape createClonnedShape() {
		throw new RuntimeException("Unimplemented method 'createClonnedShape()'"
				   				   + " in class ShapeCollector");
	}
}
