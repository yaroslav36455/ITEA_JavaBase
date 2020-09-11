package ua.itea.lesson10;

public class Eurasia {
	private String[] countries = { "Germany", "France", "Ukraine", "Poland", "Russia" };
	
	public String[] getCountries() {
		return countries;
	}
	
	public void print() {
		for (String country: countries) {
			System.out.println(country);
		}
	}
}
