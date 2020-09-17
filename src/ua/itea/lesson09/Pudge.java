package ua.itea.lesson09;

public class Pudge {
	private int health;
	private int agility;
	private int intelligence;
	private int strength;
	private int strikePower; // agility / 2 + intelligence / 3 + strength
	private Item[] items = new Item[2];
	
	public void addItem(Item item) {
		agility += item.getAgility();
		intelligence += item.getIntelligence();
		strength += item.getStrength();
	}
	
	public void getInfo() {
		System.out.println("Health: " + health
							+ "; Agility: " + agility
							+ "; Intelligence: " + intelligence
							+ "; Strength: " + strength);
	}
	
	
}
