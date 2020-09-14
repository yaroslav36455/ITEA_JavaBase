package ua.itea.lesson10.tasks;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Pudge pudge1 = new Pudge(600, 24, 11, 45);
		Pudge pudge2 = new Pudge(575, 27, 13, 43);
		ItemDistributor dist = new ItemDistributor(70.0f);
		
		for (Pudge.Slot slotNumber : Pudge.Slot.values()) {
			pudge1.set(dist.getRandomItemOrNull(), slotNumber);
		}
		
		for (Pudge.Slot slotNumber : Pudge.Slot.values()) {
			pudge2.set(dist.getRandomItemOrNull(), slotNumber);
		}
		
		do {
			System.out.println("P1: " + pudge1.getInfo());
			System.out.println("P2: " + pudge2.getInfo());
			System.out.println("-----------------------------------------");
			
			Thread.sleep(1000);
			
			pudge1.setHealth(pudge1.getHealth() - pudge2.getStrikePower());
			tryDropItem(pudge1);
			
			if (!pudge1.isAlive()) {
				break;
			}
			
			pudge2.setHealth(pudge2.getHealth() - pudge1.getStrikePower());
			tryDropItem(pudge2);
			
		} while (pudge1.isAlive() && pudge2.isAlive());
		
		System.out.println("P1: " + pudge1.getInfo());
		System.out.println("P2: " + pudge2.getInfo());
		System.out.println("-----------------------------------------");
		
		if (pudge1.isAlive()) {
			System.out.println("P1 won");
		} else {
			System.out.println("P2 won");
		}
	}
	
	private static void tryDropItem(Pudge pudge) {
		float dropItemChance = 20.f;
		
		if(Math.random() < dropItemChance / 100.f) {
			String[] itemNames = pudge.getItemsNames();
			
			if (itemNames.length != 0) {
				pudge.removeItem(itemNames[(int)(Math.random() * itemNames.length)]);
			}
		}
	}
}
