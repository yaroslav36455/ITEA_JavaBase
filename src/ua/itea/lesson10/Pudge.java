package ua.itea.lesson10;

import ua.itea.lesson10.Item;

public class Pudge {
	private int health;
	private int agility;
	private int intelligence;
	private int strength;
	private int strikePower; // agility / 2 + intelligence / 3 + strength
	private Item[] items = new Item[2];
	
	public Pudge(int health, int agility, int intelligence, int strength) {
		this.health = health;
		this.agility = agility;
		this.intelligence = intelligence;
		this.strength = strength;
		computeStrikePower();
	}
	
	public void addItem(Item item) {
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null) {
				items[i] = item;
				break;
			}
		}
		agility += item.getAgility();
		intelligence += item.getIntelligence();
		strength += item.getStrength();
		computeStrikePower();
	}
	
	public void removeItem(String name) {
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null && items[i].getName().equals(name)) {
				agility -= items[i].getAgility();
				intelligence -= items[i].getIntelligence();
				strength -= items[i].getStrength();
				items[i] = null;
				computeStrikePower();
				break;
			}
		}
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getStrikePower() {
		return strikePower;
	}
	
	private void computeStrikePower() {
		strikePower = agility / 2 + intelligence / 3 + strength;
	}
	
	public void getInfo() {
		System.out.println("Health: " + health
							+ "; Agility: " + agility
							+ "; Intelligence: " + intelligence
							+ "; Strength: " + strength
							+ "; StrikePower: " + strikePower);
		
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				System.out.println("Item №" + i + ": " + items[i].getName());
			}	
		}
	}
	
	
}
