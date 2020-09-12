package ua.itea.lesson10.tasks;

public class Pudge {	
	private int health;
	private int agility;
	private int intelligence;
	private int strength;
	private int strikePower;
	private ItemCase itemCase;
	
	public Pudge(int health, int agility, int intelligence, int strength) {
		this.health = health;
		this.agility = agility;
		this.intelligence = intelligence;
		this.strength = strength;
		itemCase = new ItemCase();
		computeStrikePower();
	}
	
	public String[] getItemsName() {
		return itemCase.getItemNames();
	}
	
	public boolean isAlive() {
		return health > 0;
	}
	
	public void addItem(Item item) {		
		itemCase.addItem(item);
		computeStrikePower();
	}
	
	public void removeItem(String name) {
		itemCase.removeItem(name);
		computeStrikePower();
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
	
	public String getInfo() {
		String log = "Health: " + health
					 + "; Agility: " + agility
					 + "; Intelligence: " + intelligence
					 + "; Strength: " + strength
					 + "; Strike Power: " + strikePower;
		
		log += "; " + itemCase.getInfo();
		
		return log;
	}
	
	private class ItemCase {
		private Item[] items = new Item[2];
		
		public String[] getItemNames() {
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
