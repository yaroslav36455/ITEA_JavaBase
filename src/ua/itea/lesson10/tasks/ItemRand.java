package ua.itea.lesson10.tasks;

public enum ItemRand {
	GEM_OF_TRUE_SIGHT(Item.GEM_OF_TRUE_SIGHT, 3),
	RING_OF_PROTECTION(Item.RING_OF_PROTECTION, 5),
	CROWN(Item.CROWN, 5),
	OGRE_AXE(Item.OGRE_AXE, 3),
	BLADES_OF_ATTACK(Item.BLADES_OF_ATTACK, 4);
	
	private Item item;
	private float weight;
	
	ItemRand(Item item, float weight) {
		this.item = item;
		this.weight = weight;
	}
	
	public Item item() {
		return item;
	}
	
	public float weight() {
		return weight;
	}
}
