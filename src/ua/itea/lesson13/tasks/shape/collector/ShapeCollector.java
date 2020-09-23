package ua.itea.lesson13.tasks.shape.collector;

import ua.itea.lesson13.tasks.ShapeContainer;
import ua.itea.lesson13.tasks.shape.factory.ShapeFactory;

public class ShapeCollector extends ShapeContainer {
	private ShapeFactory factory;
	private int limit;
	
	public ShapeCollector(ShapeFactory factory, int maxShapes) {
		super(maxShapes);
		this.factory = factory;
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
			add(factory.create());
		} else {
			System.out.println("These shapes are enough");
		}
	}
}
