package ua.itea.lesson10.tasks;

public class ItemDistributor {
	static private ItemRand[] base = {
			ItemRand.GEM_OF_TRUE_SIGHT,
			ItemRand.RING_OF_PROTECTION,
			ItemRand.CROWN,
			ItemRand.OGRE_AXE,
			ItemRand.BLADES_OF_ATTACK
			};
	
	float dropChance;
	
	
	/**
	 * @param dropChance - item drop chance as a percentage [0.0; 100.0]. 
	 */
	public ItemDistributor(float dropChance) {
		this.dropChance = dropChance;
	}
	
	Item getRandomItemOrNull() {
		Item item = null;
			
		float randomRange = getWeightSum() * (100.f / dropChance);
		float random = (float) (Math.random() * randomRange);
		float hit = 0;
		
		for (ItemRand itemRand : base) {
			hit += itemRand.weight();
			if (random < hit) {
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
