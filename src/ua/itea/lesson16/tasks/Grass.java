package ua.itea.lesson16.tasks;

public class Grass extends Item {
	
	@Override
	public ItemId getId() {
		return ItemId.GRASS;	
	}
	
	@Override
	public int getHealthMod() {
		return 0;
	}
}
