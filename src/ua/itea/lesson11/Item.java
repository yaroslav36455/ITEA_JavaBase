package ua.itea.lesson11;

public class Item {
	private String name;
	private int agility;
	private int intelligence;
	private int strength;
	
	Item(String name, int agility, int intelligence, int strength) {
		this.name = name;
		this.agility = agility;
		this.intelligence = intelligence;
		this.strength = strength;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAgility() {
		return agility;
	}
	
	public int getIntelligence() {
		return intelligence;
	}

	public int getStrength() {
		return strength;
	}
}
