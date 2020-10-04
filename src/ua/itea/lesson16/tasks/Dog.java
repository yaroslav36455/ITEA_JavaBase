package ua.itea.lesson16.tasks;

public class Dog extends Item {
	private int health;
	
	public Dog(int health) {
		this.health = health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getHealth() {
		return health;
	}
	
	public boolean isAlive() {
		return health > 0;
	}
	
	@Override
	public ItemId getId() {
		return ItemId.DOG;
	}
}
