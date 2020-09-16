package ua.itea.lesson11.tasks;

public class FigureContainer {
	private static int maxOfCircles = 3;
	private static int maxOfRectangles = 3;
	private static int maxOfTriangles = 3;
	private Figure[] figures = new Figure[maxOfCircles + maxOfRectangles + maxOfTriangles];
	private int amountOfCircles = 0;
	private int amountOfRectangles = 0;
	private int amountOfTriangles = 0;
	private int amountOfFigures = 0;

	public void add(Circle circle) {		
		if (amountOfCircles < maxOfCircles) {
			figures[amountOfFigures++] = circle;
			amountOfCircles++;
		}
	}

	public void add(Rectangle rectangle) {
		if (amountOfRectangles < maxOfRectangles) {
			figures[amountOfFigures++] = rectangle;
			amountOfRectangles++;
		}
	}

	public void add(Triangle triangle) {
		if (amountOfTriangles < maxOfTriangles) {
			figures[amountOfFigures++] = triangle;
			amountOfTriangles++;
		}
	}

	public boolean isFull() {
		return isFullOfCircles() && isFullOfRectangles() && isFullOfTriangles();
	}

	public boolean isFullOfCircles() {
		return amountOfCircles == maxOfCircles;
	}

	public boolean isFullOfRectangles() {
		return amountOfRectangles == maxOfRectangles;
	}

	public boolean isFullOfTriangles() {
		return amountOfTriangles == maxOfTriangles;
	}

	public void printFullnessInfo() {
		System.out.println("Circles: " + amountOfCircles + "/" + maxOfCircles
						   + "; Rectangles: " + amountOfRectangles + "/" + maxOfRectangles
						   + "; Triangles: " + amountOfTriangles + "/" + maxOfTriangles);
	}
	
	public void printFiguresInfo() {
		if(amountOfCircles == 0
				&& amountOfRectangles == 0
				&& amountOfTriangles == 0) {
			System.out.println("No figures");
			return;
		}
		System.out.println("┏━┯━━━━━━━━━┯━━━━━━━━━┯━━━━━━━━━┯━━━━━━┓");
		System.out.println("┃№│Figure   │Perimeter│Area     │Color ┃");
		System.out.println("┠─┼─────────┼─────────┼─────────┼──────┨");
		String format = "┃%d│%-9s│%.3e│%.3e│%-6s┃\n";
		
		int counter = 1;
		
		for (int i = 0; i < amountOfFigures; i++) {
			System.out.printf(format, counter++,
									  figures[i].getName(),
									  figures[i].getPerimeter(),
									  figures[i].getArea(),
									  figures[i].getColor());
		}
		
		System.out.println("┗━┷━━━━━━━━━┷━━━━━━━━━┷━━━━━━━━━┷━━━━━━┛");
	}

	public int amountOfCircles() {
		return amountOfCircles;
	}

	public int amountOfRectangles() {
		return amountOfRectangles;
	}

	public int amountOfTriangles() {
		return amountOfTriangles;
	}
}
