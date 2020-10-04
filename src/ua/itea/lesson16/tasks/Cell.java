package ua.itea.lesson16.tasks;

public class Cell {
	private Item item;
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public Item getItem() {
		return item;
	}
	
	public boolean isEmpty() {
		return item == null;
	}
}
