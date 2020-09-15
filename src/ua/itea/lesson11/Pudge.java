package ua.itea.lesson11;

public class Pudge extends Hero {

	public Pudge(int health, int agility, int intelligence, int strength) {
		super(health, agility, intelligence, strength);
		
	}
	
	@Override
	protected void computeStrikePower() {
		strikePower = strength / 2 + intelligence / 3 + agility;
	}
	
	@Override
	public void getUltimate() {
		System.out.println("Meat Hook");
	}

}
