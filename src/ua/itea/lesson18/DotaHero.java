package ua.itea.lesson18;

import java.util.Objects;

public class DotaHero {
	private String name;
	private int level;
	
	public DotaHero(String name, int level) {
		this.name = name;
		this.level = level;
	}

	@Override
	public String toString() {
		return "DotaHero [name=" + name + ", level=" + level + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(level, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		DotaHero other = (DotaHero) obj;
		return level == other.level && Objects.equals(name, other.name);
	}
	
	
}
