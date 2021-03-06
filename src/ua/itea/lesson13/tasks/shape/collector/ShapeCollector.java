package ua.itea.lesson13.tasks.shape.collector;

import ua.itea.lesson13.tasks.CollectorOverflowException;
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
	
	public void addShape() throws CollectorOverflowException {
		if (isFull()) {
			throw new CollectorOverflowException("These shapes are enough");
		}

		add(createClonnedShape());
	}
	
	protected Shape createClonnedShape() {
		throw new RuntimeException("Unimplemented method 'createClonnedShape()'"
				   				   + " in class ShapeCollector");
	}
}
