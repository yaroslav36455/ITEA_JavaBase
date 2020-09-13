package ua.itea.lesson10.tasks;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Pudge pudge1 = new Pudge(700, 24, 11, 35);
		Pudge pudge2 = new Pudge(675, 27, 13, 33);
		Duel duel = new Duel(pudge1, pudge2);
		
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
