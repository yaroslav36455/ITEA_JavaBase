package ua.itea.lesson9.tasks;

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
		
		for (int i = 0; i < amountOfCircles; i++) {
			circles[i].printInfo();
		}
		
		for (int i = 0; i < amountOfRectangles; i++) {
			rectangles[i].printInfo();
		}
		
		for (int i = 0; i < amountOfTriangles; i++) {
			triangles[i].printInfo();
		}
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
