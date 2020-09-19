package ua.itea.lesson11.tasks;

import java.util.Arrays;

import ua.itea.lesson11.tasks.figure.Figure;

public class FigureContainer {
	private Figure[] figures;
	private int size = 0;
	
	public FigureContainer() {
	} 
	
	public FigureContainer(int capacity) {
		expandArrayCapacity(capacity);
	}
	
	public FigureContainer(Figure figure, Figure ...figures) {
		add(figure, figures);
	}
	
	public FigureContainer(FigureContainer container,
						   FigureContainer ...containers) {
		add(container, containers);
	}
	
	public int size() {
		return size;
	}
	
	public int capacity() {
		return figures.length;
	}
	
	public void add(Figure figure, Figure ...figures) {
		int count = figure == null ? 0 : 1;
		
		for (Figure fig : figures) {
			if (fig != null) {
				count++;
			}
		}
		
		expandArrayCapacity(size() + count);
		
		addWithoutExpandingCapacity(figure);
		addWithoutExpandingCapacity(figures);
	}
	
	private void addWithoutExpandingCapacity(Figure ...figures) {
		for (Figure fig : figures) {
			if (fig != null) {
				this.figures[size++] = fig;
			}
		}
	}
	
	public void add(FigureContainer container, FigureContainer ...containers) {
		int count = container.size();
		
		for (FigureContainer cont : containers) {
			count += cont.size();
		}
		
		expandArrayCapacity(size() + count);
		
		addWithoutExpandingCapacity(container);
		addWithoutExpandingCapacity(containers);
	}
	
	private void addWithoutExpandingCapacity(FigureContainer ...containers) {
		for (FigureContainer container : containers) {
			Figure[] source = container.getFigures();
			
			System.arraycopy(source, 0, figures, size, source.length);
			size += source.length;
		}
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public Figure[] getFigures() {
		return Arrays.copyOf(figures, size());
	}
	
	private void expandArrayCapacity(int newMinCapacity) {
		if (figures == null) {
			figures = new Figure[newMinCapacity];
		} else if (newMinCapacity > capacity()) {
			figures = Arrays.copyOf(figures, computeNewCapacity(newMinCapacity));
		}
	}
	
	private int computeNewCapacity(int newMinCapacity) {
		int capacity = capacity() == 0 ? 1 : capacity();
		
		while (capacity < newMinCapacity) {
			capacity *= 2;
		}
		
		return capacity;
	}
}
