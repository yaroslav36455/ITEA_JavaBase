package ua.itea.lesson11.tasks;

import ua.itea.lesson11.tasks.figure.Figure;

public class FigureContainer {
	private Figure[] figures;
	private int size = 0;
	
	public FigureContainer(int capacity) {
		figures = new Figure[capacity];
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
		
		addWithoutExpandingCapacity(container.getFigures());
		for (FigureContainer cont : containers) {
			addWithoutExpandingCapacity(cont.getFigures());
		}
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public Figure[] getFigures() {
		Figure[] figures = new Figure[size()];
		
		for (int i = 0; i < size(); i++) {
			figures[i] = this.figures[i];
		}
		return figures;
	}
	
	private void expandArrayCapacity(int newMinCapacity) {
		if (figures == null) {
			figures = new Figure[newMinCapacity];
		} else if (newMinCapacity > capacity()) {
			Figure[] newArray = new Figure[computeNewCapacity(newMinCapacity)];
			
			for (int i = 0; i < size(); i++) {
				newArray[i] = figures[i];
			}
			figures = newArray;
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
