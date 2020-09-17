package ua.itea.lesson12;

public class Samsung extends Smartphone {
	private boolean hasGPS;
	
	public Samsung(double screenSize, String model) {
		super(screenSize, model);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void getInfo() {
		super.getInfo();
		System.out.println("Has GPS: " + hasGPS);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (hasGPS ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Samsung other = (Samsung) obj;
		if (hasGPS != other.hasGPS)
			return false;
		return true;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null) {
//			return false;
//		}
//		
//		if (!this.getClass().equals(obj.getClass())) {
//			return false;
//		}
//		
//		Samsung otherSamsung = (Samsung) obj;
//		return screenSize == otherSamsung.screenSize
//				&& model.equals(otherSamsung.model)
//				&& hasGPS == otherSamsung.hasGPS;
//	}
}
