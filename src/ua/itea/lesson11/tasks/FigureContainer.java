package ua.itea.lesson11.tasks;

public class FigureContainer {
	private Circle[] circles = new Circle[3];
	private Rectangle[] rectangles = new Rectangle[3];
	private Triangle[] triangles = new Triangle[3];
	private int amountOfCircles = 0;
	private int amountOfRectangles = 0;
	private int amountOfTriangles = 0;

	public void add(Circle circle) {		
		if (amountOfCircles < circles.length) {
			circles[amountOfCircles++] = circle;
		}
	}

	public void add(Rectangle rectangle) {
		if (amountOfRectangles < rectangles.length) {
			rectangles[amountOfRectangles++] = rectangle;
		}
	}

	public void add(Triangle triangle) {
		if (amountOfTriangles < triangles.length) {
			triangles[amountOfTriangles++] = triangle;
		}
	}

	public boolean isFull() {
		return isFullOfCircles() && isFullOfRectangles() && isFullOfTriangles();
	}

	public boolean isFullOfCircles() {
		return amountOfCircles == circles.length;
	}

	public boolean isFullOfRectangles() {
		return amountOfRectangles == rectangles.length;
	}

	public boolean isFullOfTriangles() {
		return amountOfTriangles == triangles.length;
	}

	public void printFullnessInfo() {
		System.out.println("Circles: " + amountOfCircles + "/" + circles.length
						   + "; Rectangles: " + amountOfRectangles + "/" + rectangles.length
						   + "; Triangles: " + amountOfTriangles + "/" + triangles.length);
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
		
		for (int i = 0; i < amountOfCircles; i++) {
			System.out.printf(format, counter++,
									  circles[i].getName(),
									  circles[i].getPerimeter(),
									  circles[i].getArea(),
									  circles[i].getColor());
		}
		
		for (int i = 0; i < amountOfRectangles; i++) {
			System.out.printf(format, counter++,
									  rectangles[i].getName(),
									  rectangles[i].getPerimeter(),
									  rectangles[i].getArea(),
									  rectangles[i].getColor());
		}
		
		for (int i = 0; i < amountOfTriangles; i++) {
			System.out.printf(format, counter++,
									  triangles[i].getName(),
									  triangles[i].getPerimeter(),
									  triangles[i].getArea(),
									  triangles[i].getColor());
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
