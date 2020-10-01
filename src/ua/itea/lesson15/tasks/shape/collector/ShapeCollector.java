package ua.itea.lesson15.tasks.shape.collector;

import ua.itea.lesson15.tasks.CollectorOverflowException;
import ua.itea.lesson15.tasks.ShapeContainer;
import ua.itea.lesson15.tasks.shape.Shape;

public class ShapeCollector {
	private ShapeContainer container;
	private int limit;
	private int size;
	
	public ShapeCollector(ShapeContainer container, int maxShapes) {
		this.container = container;
		this.limit = maxShapes;
		size = 0;
	}
	
	public int size() {
		return size;
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

		container.add(createClonnedShape());
		size++;
	}
	
	protected Shape createClonnedShape() {
		throw new RuntimeException("Unimplemented method 'createClonnedShape()'"
				   				   + " in class ShapeCollector");
	}
}
