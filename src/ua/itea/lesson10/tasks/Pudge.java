package ua.itea.lesson10.tasks;

public class Pudge {	
	private int health;
	private int agility;
	private int intelligence;
	private int strength;
	private int strikePower;
	private Slots slots;
	
	public Pudge(int health, int agility, int intelligence, int strength) {
		this.health = health;
		this.agility = agility;
		this.intelligence = intelligence;
		this.strength = strength;
		slots = new Slots();
		computeStrikePower();
	}
	
	public Slots getSlots() {
		return slots;
	}
	
	public boolean isAlive() {
		return health > 0;
	}
	
	public String[] getItemsNames() {
		return slots.getItemsNames();
	}
	
	public void addItemOrNull(Item item) {
		if(item != null) {
			addItem(item);
		}
	}
	
	public void addItem(Item item) {		
		slots.addItem(item);
		computeStrikePower();
	}
	
	public void removeItem(String name) {
		slots.removeItem(name);
		computeStrikePower();
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getHealth() {
		return health;
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
	
	public int getStrikePower() {
		return strikePower;
	}
	
	private void computeStrikePower() {
		strikePower = agility / 2 + intelligence / 3 + strength;
	}
	
	public String getInfo() {
		String log = String.format("Health %4d|Agility %3d|Intelligence %3d|"
								   + "Strength %3d|Strike Power %3d",
								   health, agility, intelligence,
								   strength, strikePower);
		
		log += "; " + slots.getInfo();
		
		return log;
	}
	
	private class Slots {
		private Item[] items = new Item[2];
		
		public String[] getItemsNames() {
			int count = numberOfItems();
			String[] names = new String[count];
			int i = 0;
			
			for(Item item: items) {
				if (item != null) {
					names[i++] = item.getName();
				}
			}
			
			return names;
		}
		
		private int numberOfItems() {
			int count = 0;
			for(Item item: items) {
				if(item != null) {
					count++;
				}
			}
			return count;
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
		}
		
		public void removeItem(String name) {
			for (int i = 0; i < items.length; i++) {
				if (items[i] != null && items[i].getName().equals(name)) {
					agility -= items[i].getAgility();
					intelligence -= items[i].getIntelligence();
					strength -= items[i].getStrength();
					items[i] = null;
					break;
				}
			}
		}
		
		public String getInfo() {
			String log = "";
			for (int i = 0; i < items.length; i++) {
				log += "Item №" + (i + 1) + ": "
					   + ((items[i] == null) ? "<empty>" : items[i].getName())
					   + ((i < items.length - 1) ? "; " : "");
			}
			return log;
		}
	}
}
