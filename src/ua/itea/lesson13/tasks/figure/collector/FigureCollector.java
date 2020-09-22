package ua.itea.lesson13.tasks.figure.collector;

import ua.itea.lesson13.tasks.FigureContainer;
import ua.itea.lesson13.tasks.figure.factory.FigureFactory;

public class FigureCollector extends FigureContainer {
	private FigureFactory factory;
	private int limit;
	
	public FigureCollector(FigureFactory factory, int maxFigures) {
		super(maxFigures);
		this.factory = factory;
		this.limit = maxFigures;
	}
	
	public int limit() {
		return limit;
	}
	
	public boolean isFull() {
		return !(size() < limit());
	}
	
	public void addFigure() {
		if (!isFull()) {
			add(factory.create());
		} else {
			System.out.println("These figures are enough");
		}
	}
}
