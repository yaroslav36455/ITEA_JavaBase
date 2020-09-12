package ua.itea.lesson10.tasks;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Pudge pudge1 = new Pudge(1000, 24, 12, 60);
		Pudge pudge2 = new Pudge(920, 31, 16, 62);
		Duel duel = new Duel(pudge1, pudge2);
		
		ItemDistributor dist = new ItemDistributor(100.0f);
		
		pudge1.addItemOrNull(dist.getRandomItemOrNull());
		pudge1.addItemOrNull(dist.getRandomItemOrNull());
		pudge2.addItemOrNull(dist.getRandomItemOrNull());
		pudge2.addItemOrNull(dist.getRandomItemOrNull());
		
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
