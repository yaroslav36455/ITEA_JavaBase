package ua.itea.lesson10.tasks;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		Pudge pudge1 = new Pudge(1000, 24, 12, 60);
		Pudge pudge2 = new Pudge(920, 31, 16, 62);
		
		System.out.println("P1: " + pudge1.getInfo());
		System.out.println("P2: " + pudge2.getInfo());
		System.out.println("=========================================");
		
		ItemDistributor dist = new ItemDistributor(100.0f);
		Item randItem = null;
		
		randItem = dist.getRandomItemOrNull();
		if (randItem != null) {
			pudge1.addItem(randItem);
		}
		
		randItem = dist.getRandomItemOrNull();
		if (randItem != null) {
			pudge1.addItem(randItem);
		}
		
		randItem = dist.getRandomItemOrNull();
		if (randItem != null) {
			pudge2.addItem(randItem);
		}
		
		randItem = dist.getRandomItemOrNull();
		if (randItem != null) {
			pudge2.addItem(randItem);
		}
		
		while (pudge1.isAlive() && pudge2.isAlive()) {
			Thread.sleep(1000);
			
			System.out.println("P1: " + pudge1.getInfo());
			System.out.println("P2: " + pudge2.getInfo());
			System.out.println("-----------------------------------------");
			
			pudge1.setHealth(pudge1.getHealth() - pudge2.getStrikePower());
			if(Math.random() < 0.0) {
				String[] itemNames = pudge1.getItemsName();
				if (itemNames.length != 0) {
					int i = (int)(Math.random() * itemNames.length);
					pudge1.removeItem(itemNames[i]);
				}
			}
			if (!pudge1.isAlive()) {
				break;
			}
			
			pudge2.setHealth(pudge2.getHealth() - pudge1.getStrikePower());
			if(Math.random() < 0.0) {
				String[] itemNames = pudge2.getItemsName();
				if (itemNames.length != 0) {
					int i = (int)(Math.random() * itemNames.length);
					pudge2.removeItem(itemNames[i]);
				}
			}
		}
		
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
