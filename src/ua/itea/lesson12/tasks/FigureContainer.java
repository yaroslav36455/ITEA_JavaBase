package ua.itea.lesson12.tasks;

import java.util.Arrays;

import ua.itea.lesson12.tasks.figure.Figure;

public class FigureContainer {
	private Figure[] figures;
	private int size = 0;
	
	public FigureContainer() {
		figures = new Figure[0];
	} 
	
	public FigureContainer(int capacity) {
		figures = new Figure[getCapacity(capacity)];
	}
	
	public FigureContainer(Figure figure, Figure ...figures) {
		figures = new Figure[getCapacity(numberOfFigures(figure, figures))];
		addWithoutExpandingCapacity(figure);
		addWithoutExpandingCapacity(figures);
	}
	
	public FigureContainer(FigureContainer container,
						   FigureContainer ...containers) {
		figures = new Figure[getCapacity(numberOfFigures(container, containers))];
		addWithoutExpandingCapacity(container);
		addWithoutExpandingCapacity(containers);
	}
	
	public int size() {
		return size;
	}
	
	public int capacity() {
		return figures.length;
	}
	
	public void add(Figure figure, Figure ...figures) {
		int count = numberOfFigures(figure, figures);
		
		expandArrayCapacity(size() + count);
		addWithoutExpandingCapacity(figure);
		addWithoutExpandingCapacity(figures);
	}
	
	private int numberOfFigures(Figure figure, Figure ...figures) {
		int count = figure == null ? 0 : 1;
		
		for (Figure fig : figures) {
			if (fig != null) {
				count++;
			}
		}
		
		return count;
	}
	
	private void addWithoutExpandingCapacity(Figure figure) {
		if (figure != null) {
			this.figures[size++] = figure;
		}
	}
	
	private void addWithoutExpandingCapacity(Figure[] figures) {
		for (Figure fig : figures) {
			addWithoutExpandingCapacity(fig);
		}
	}
	
	public void add(FigureContainer container, FigureContainer ...containers) {
		int count = numberOfFigures(container, containers);
		
		expandArrayCapacity(size() + count);
		addWithoutExpandingCapacity(container);
		addWithoutExpandingCapacity(containers);
	}
	
	private int numberOfFigures(FigureContainer container, FigureContainer ...containers) {
		int count = container.size();
		
		for (FigureContainer cont : containers) {
			count += cont.size();
		}
		
		return count;
	}
	
	private void addWithoutExpandingCapacity(FigureContainer container) {
		Figure[] source = container.getFigures();
		
		System.arraycopy(source, 0, figures, size, source.length);
		size += source.length;
	}
	
	private void addWithoutExpandingCapacity(FigureContainer[] containers) {
		for (FigureContainer cont : containers) {
			addWithoutExpandingCapacity(cont);
		}
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public Figure[] getFigures() {
		return Arrays.copyOf(figures, size());
	}
	
	private void expandArrayCapacity(int newMinCapacity) {
		if (newMinCapacity > capacity()) {
			figures = Arrays.copyOf(figures, getCapacity(newMinCapacity));
		}
	}
	
	private int getCapacity(int newMinCapacity) {
		int capacity = (figures == null || capacity() == 0) ? 1 : capacity();
		
		while (capacity < newMinCapacity) {
			capacity <<= 1;
		}
		
		return capacity;
	}
	
	@Override
	public String toString() {
		if(isEmpty()) {
			return "No figures";
		} else {
			StringBuffer result = new StringBuffer();
			int counter = 1;
			
			result.append("┏━┯━━━━━━━━━┯━━━━━━━━━┯━━━━━━━━━┯━━━━━━┓\n");
			result.append("┃№│Figure   │Perimeter│Area     │Color ┃\n");
			result.append("┠─┼─────────┼─────────┼─────────┼──────┨\n");

			for (Figure figure : getFigures()) {
				result.append(String.format("┃%d│%-9s│%.3e│%.3e│%-6s┃\n",
											counter++,
								  	  		figure.getName(),
								  	  		figure.getPerimeter(),
								  	  		figure.getArea(),
								  	  		figure.getColor()));
			}

			result.append("┗━┷━━━━━━━━━┷━━━━━━━━━┷━━━━━━━━━┷━━━━━━┛");

			result.trimToSize();
			return result.toString();
		}
	}
}
