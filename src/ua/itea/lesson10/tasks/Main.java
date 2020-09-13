package ua.itea.lesson10.tasks;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Pudge pudge1 = new Pudge(700, 24, 11, 35);
		Pudge pudge2 = new Pudge(650, 27, 13, 32);
		Duel duel = new Duel(pudge1, pudge2);
		
		ItemDistributor dist = new ItemDistributor(70.0f);
		Pudge.Slots pudge1Slots = pudge1.getSlots();
		Pudge.Slots pudge2Slots = pudge2.getSlots();
		
		pudge1Slots.set(dist.getRandomItemOrNull(), Pudge.Slot.NUM_1);
		pudge1Slots.set(dist.getRandomItemOrNull(), Pudge.Slot.NUM_2);
		pudge2Slots.set(dist.getRandomItemOrNull(), Pudge.Slot.NUM_1);
		pudge2Slots.set(dist.getRandomItemOrNull(), Pudge.Slot.NUM_2);
		
		do {
			System.out.println("P1: " + pudge1.getInfo());
			System.out.println("P2: " + pudge2.getInfo());
			System.out.println("-----------------------------------------");
			
			Thread.sleep(1000);
			
		} while (duel.continueDuel());
		
		System.out.println("P1: " + pudge1.getInfo());
		System.out.println("P2: " + pudge2.getInfo());
		System.out.println("-----------------------------------------");
		
		if (pudge1.isAlive()) {
			System.out.println("P1 won");
		} else {
			System.out.println("P2 won");
		}
	}
}
