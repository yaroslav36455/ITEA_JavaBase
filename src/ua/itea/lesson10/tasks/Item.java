package ua.itea.lesson10.tasks;

public enum Item {
	GEM_OF_TRUE_SIGHT("Gem of true sight", 7, 32, 14),
	RING_OF_PROTECTION("Ring of Protection", 17, 13, 4),
	CROWN("Crown", 0, 20, 14),
	OGRE_AXE("Ogre Axe", 3, 1, 21),
	BLADES_OF_ATTACK("Blades of Attack", 16, 4, 10);
	
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
