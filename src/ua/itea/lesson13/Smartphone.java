package ua.itea.lesson13;

public class Smartphone implements Cloneable {
	protected double screenSize;
	public String model;
	
//	public Smartphone() {
//		
//	}

	public Smartphone(double screenSize, String model) {
		this.screenSize = screenSize;
		this.model = model;
	}
	
	public void getInfo() {
		System.out.print("Model: " + model
						 + "; Screen size: " + screenSize);
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((model == null) ? 0 : model.hashCode());
//		long temp;
//		temp = Double.doubleToLongBits(screenSize);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		return result;
//	}

	@Override
	public String toString() {
		return "Smartphone [screenSize=" + screenSize + ", model=" + model + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Smartphone other = (Smartphone) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(screenSize) != Double.doubleToLongBits(other.screenSize))
			return false;
		return true;
	}
	
	
}
