package ua.itea.lesson15.tasks;

import java.util.Arrays;

import ua.itea.lesson15.tasks.shape.Shape;

public class ShapeArray extends ShapeContainer {
	private Shape[] shapes;
	private int size = 0;
	
	public ShapeArray() {
		shapes = new Shape[0];
	} 
	
	public ShapeArray(int capacity) {
		shapes = new Shape[getCapacity(capacity)];
	}
	
	public ShapeArray(Shape shape, Shape ...shapes) {
		shapes = new Shape[getCapacity(numberOfShapes(shape, shapes))];
		addWithoutExpandingCapacity(shape);
		addWithoutExpandingCapacity(shapes);
	}
	
	public ShapeArray(ShapeContainer container,
					  ShapeContainer ...containers) {
		shapes = new Shape[getCapacity(numberOfShapes(container, containers))];
		addWithoutExpandingCapacity(container);
		addWithoutExpandingCapacity(containers);
	}
	
	@Override
	public int size() {
		return size;
	}
	
	public int capacity() {
		return shapes.length;
	}
	
	@Override
	public void add(Shape shape, Shape ...shapes) {
		int count = numberOfShapes(shape, shapes);
		
		expandArrayCapacity(size() + count);
		addWithoutExpandingCapacity(shape);
		addWithoutExpandingCapacity(shapes);
	}
	
	private int numberOfShapes(Shape shape, Shape ...shapes) {
		int count = shape == null ? 0 : 1;
		
		for (Shape sh : shapes) {
			if (sh != null) {
				count++;
			}
		}
		
		return count;
	}
	
	private void addWithoutExpandingCapacity(Shape shape) {
		if (shape != null) {
			this.shapes[size++] = shape;
		}
	}
	
	private void addWithoutExpandingCapacity(Shape[] shapes) {
		for (Shape sh : shapes) {
			addWithoutExpandingCapacity(sh);
		}
	}
	
	@Override
	public void add(ShapeContainer container, ShapeContainer ...containers) {
		int count = numberOfShapes(container, containers);
		
		expandArrayCapacity(size() + count);
		addWithoutExpandingCapacity(container);
		addWithoutExpandingCapacity(containers);
	}
	
	private int numberOfShapes(ShapeContainer container, ShapeContainer ...containers) {
		int count = container.size();
		
		for (ShapeContainer cont : containers) {
			count += cont.size();
		}
		
		return count;
	}
	
	private void addWithoutExpandingCapacity(ShapeContainer container) {
		Shape[] source = container.getShapes();
		
		System.arraycopy(source, 0, shapes, size, source.length);
		size += source.length;
	}
	
	private void addWithoutExpandingCapacity(ShapeContainer[] containers) {
		for (ShapeContainer cont : containers) {
			addWithoutExpandingCapacity(cont);
		}
	}
	
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
	
	@Override
	public Shape[] getShapes() {
		return Arrays.copyOf(shapes, size());
	}
	
	private void expandArrayCapacity(int newMinCapacity) {
		if (newMinCapacity > capacity()) {
			shapes = Arrays.copyOf(shapes, getCapacity(newMinCapacity));
		}
	}
	
	private int getCapacity(int newMinCapacity) {
		int capacity = (shapes == null || capacity() == 0) ? 1 : capacity();
		
		while (capacity < newMinCapacity) {
			capacity <<= 1;
		}
		
		return capacity;
	}
}
