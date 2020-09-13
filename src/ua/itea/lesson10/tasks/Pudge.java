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
		String log = String.format("Health %4d| Agility %3d| Intelligence %3d|"
								   + " Strength %3d| Strike Power %3d",
								   health, agility, intelligence,
								   strength, strikePower);
		
		log += "|| " + slots.getInfo();
		
		return log;
	}
	
	public enum Slot {
		NUM_1(0),
		NUM_2(1);
		
		private int num;
		
		Slot(int num) {
			this.num = num;
		}
		
		public int get() {
			return num;
		}
	}
	
	public class Slots {
		private Slot[] slots = new Slot[Pudge.Slot.values().length];
		
		public Slots() {
			for(int i = 0; i < slots.length; i++) {
				slots[i] = new Slot();
			}
		}
		
		public String[] getItemsNames() {
			int count = getNumberOfItems();
			String[] names = new String[count];
			int i = 0;
			
			for(Slot slot: slots) {
				if (slot.hasItem()) {
					names[i++] = slot.getItemName();
				}
			}
			
			return names;
		}
		
		public int getNumberOfSlots() {
			return slots.length;
		}
		
		public int getNumberOfItems() {
			int count = 0;
			for(Slot slot: slots) {
				if(slot.hasItem()) {
					count++;
				}
			}
			return count;
		}
		
		/**
		 * Set or remove item
		 * @param item - item or null
		 * @param slotNumber - slot number
		 * @return old item or null
		 */
		public Item set(Item item, Pudge.Slot slotNumber) {
			return slots[slotNumber.get()].set(item);
		}
		
		public void removeItem(String name) {
			for (Slot slot : slots) {
				if (slot.hasItem() && slot.getItemName().equals(name)) {
					slot.removeItem();
					break;
				}
			}
		}
		
		public String getInfo() {
			StringBuilder format = new StringBuilder("Items: [");
			String[] info = new String[getNumberOfSlots()];
			
			for (int i = 0; i < info.length; i++) {
				format.append("%20s");
				info[i] = slots[i].getInfo();
				if(i < info.length - 1) {
					format.append(",");
				}
			}
			
			format.append("]");
			return String.format(format.toString(), (Object[]) info);
		}
		
		private class Slot {
			private Item item;
			
			public String getInfo() {
				return isEmpty() ? "<empty>" : item.getName();
			}
			
			public String getItemName() {
				return item.getName();
			}
			
			public boolean hasItem() {
				return !isEmpty();
			}
			
			public boolean isEmpty() {
				return item == null;
			}
			
			public Item set(Item newItem) {
				Item oldItem = this.item;
				item = newItem;
				
				subStats(oldItem);
				addStats(newItem);
				
				computeStrikePower();
				return oldItem;
			}
			
			public Item removeItem() {
				Item oldItem = item;
				item = null;
				
				subStats(oldItem);
				
				computeStrikePower();
				return oldItem;
			}
			
			private void subStats(Item item) {
				if (item != null) {
					agility -= item.getAgility();
					intelligence -= item.getIntelligence();
					strength -= item.getStrength();
				}
			}
			
			private void addStats(Item item) {
				if (item != null) {
					agility += item.getAgility();
					intelligence += item.getIntelligence();
					strength += item.getStrength();
				}
			}
		}
	}
}
