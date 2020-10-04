package ua.itea.lesson16.tasks;

public class FirstAid extends Item {
	
	@Override
	public int getHealthMod() {
		return 40;
	}
	
	@Override
	public ItemId getId() {
		return ItemId.FIRST_AID_KIT;
	}
}
