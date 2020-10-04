package ua.itea.lesson16.tasks;

public class Bomb extends Item {
	
	@Override
	public int getHealthMod() {
		return -40;
	}
	
	@Override
	public ItemId getId() {
		return ItemId.BOMB;
	}
}
