package ua.itea.lesson10.tasks;

public class Duel {
	private float dropItemChance = 20.f;
	private Pudge pudge1;
	private Pudge pudge2;
	
	public Duel(Pudge pudge1, Pudge pudge2) {
		this.pudge1 = pudge1;
		this.pudge2 = pudge2;
	}
	
	public boolean isInProgress() {
		return pudge1.isAlive() && pudge2.isAlive();
	}
	
	public boolean continueDuel() {
		pudge1.setHealth(pudge1.getHealth() - pudge2.getStrikePower());
		tryDropItem(pudge1);
		
		if (!pudge1.isAlive()) {
			return false;
		}
		
		pudge2.setHealth(pudge2.getHealth() - pudge1.getStrikePower());
		tryDropItem(pudge2);
		
		return pudge2.isAlive();
	}
	
	private void tryDropItem(Pudge pudge) {
		if(Math.random() < dropItemChance / 100.f) {
			String[] itemNames = pudge.getItemsNames();
			
			if (itemNames.length != 0) {
				pudge.removeItem(itemNames[(int)(Math.random() * itemNames.length)]);
			}
		}
	}
}