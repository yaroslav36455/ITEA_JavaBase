package ua.itea.lesson15.tasks.shape.collector;

import ua.itea.lesson15.tasks.CollectorOverflowException;
import ua.itea.lesson15.tasks.ShapeContainer;
import ua.itea.lesson15.tasks.shape.Shape;

public class ShapeCollector {
	ShapeContainer container;
	private int limit;
	
	public ShapeCollector(ShapeContainer container, int maxShapes) {
		this.container = container;
		this.limit = maxShapes;
	}
	
	public int size() {
		return container.size();
	}
	
	public int limit() {
		return limit;
	}
	
	public boolean isFull() {
		return !(container.size() < limit());
	}
	
	public void addShape() throws CollectorOverflowException {
		if (isFull()) {
			throw new CollectorOverflowException("These shapes are enough");
		}

		container.add(createClonnedShape());
	}
	
	protected Shape createClonnedShape() {
		throw new RuntimeException("Unimplemented method 'createClonnedShape()'"
				   				   + " in class ShapeCollector");
	}
	
	public ShapeContainer getContainer() {
		return container;
	}
}
