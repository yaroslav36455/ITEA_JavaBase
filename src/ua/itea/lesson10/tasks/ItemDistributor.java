package ua.itea.lesson10.tasks;

public class ItemDistributor {
	static private ItemRand[] base = {
			ItemRand.GEM_OF_TRUE_SIGHT,
			ItemRand.RING_OF_PROTECTION,
			ItemRand.CROWN,
			ItemRand.OGRE_AXE,
			ItemRand.BLADES_OF_ATTACK
			};
	
	float weightSum;
	float dropChance;
	
	/**
	 * @param dropChance - item drop chance as a percentage [0.0; 100.0]. 
	 */
	public ItemDistributor(float dropChance) {
		this.dropChance = dropChance;
		weightSum = getWeightSum();
	}
	
	public int numberOfItems() {
		return base.length;
	}
	
	Item getRandomItemOrNull() {
		Item item = null;
		
		float range = weightSum * (100.f / dropChance);
		float hit = (float) (Math.random() * range);
		float weightCounter = 0;
		
		for (ItemRand itemRand : base) {
			weightCounter += itemRand.weight();
			if (hit < weightCounter) {
				item = itemRand.item();
				break;
			}
		}
		
		return item;
	}
	
	static private int getWeightSum() {
		int sum = 0;
		for (ItemRand ir: base ) {
			sum += ir.weight();
		}
		return sum;
	}
}
