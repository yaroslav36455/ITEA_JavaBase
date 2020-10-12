package ua.itea.lesson18;

public class CrystalMaiden extends DotaHero implements Hero {

	public CrystalMaiden(String name, int level) {
		super(name, level);
	}
	
	@Override
	public String getFirstAbility() {
		return "Frost Bite";
	}

	@Override
	public String getUltimate() {
		return "New Year";
	}

}
