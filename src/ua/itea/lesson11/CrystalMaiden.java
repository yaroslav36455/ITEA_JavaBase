package ua.itea.lesson11;

public class CrystalMaiden extends Hero {
	
	public CrystalMaiden(int health, int agility, int intelligence, int strength) {
		super(health, agility, intelligence, strength);
		
	}
	
	@Override
	protected void computeStrikePower() {
		strikePower = agility / 2 + strength / 3 + intelligence;
	}
	
	@Override
	public void getUltimate() {
		System.out.println("Ice Rain");
	}
}
