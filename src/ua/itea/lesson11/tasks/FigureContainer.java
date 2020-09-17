package ua.itea.lesson11.tasks;

import ua.itea.lesson11.tasks.figure.Figure;

public class FigureContainer {
	private Figure[] figures;
	private int size = 0;
	
	public FigureContainer(int capacity) {
		figures = new Figure[capacity];
	}
	
	public int size() {
		return size;
	}
	
	public int capacity() {
		return figures.length;
	}

	public void add(Figure figure) {
		figures[size] = figure;
		size++;
	}

	public boolean isFull() {
		return size() == capacity();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public Figure[] getFigures() {
		return figures.clone();
	}
}
