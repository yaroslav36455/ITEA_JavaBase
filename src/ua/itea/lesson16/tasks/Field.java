package ua.itea.lesson16.tasks;

public class Field {
	private ClosedIntRange widthRange;
	private ClosedIntRange heightRange;
	private Cell[][] cells;

	/**
	 * @param width - field width [1; Integer.MAX_VALUE)
	 * @param height - field height [1; Integer.MAX_VALUE)
	 */
	public Field(int width, int height) {
		widthRange = new ClosedIntRange(1, width);
		heightRange = new ClosedIntRange(1, height);
		
		cells = new Cell[height][width];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				cells[y][x] = new Cell();
			}
			
		}
	}
	
	public int getWidth() {
		return widthRange.getSpan();
	}
	
	public int getHeight() {
		return heightRange.getSpan();
	}
	
	/**
	 * @param x - coordinate from left to right [1; Integer.MAX_VALUE]
	 * @param y - coordinate from top to bottom [1; Integer.MAX_VALUE]
	 * @return Cell
	 */
	public Cell getCell(int x, int y) {
		return cells[y - 1][x - 1];
	}
	
	public Cell getCell(Position pos) {
		return getCell(pos.getX(), pos.getY());
	}
	
	public boolean isWithin(int x, int y) {
		return widthRange.isWithin(x) && heightRange.isWithin(y);
	}
	
	public boolean isWithin(Position pos) {
		return isWithin(pos.getX(), pos.getY());
	}
}
