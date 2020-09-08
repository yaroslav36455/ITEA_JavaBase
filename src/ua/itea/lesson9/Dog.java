package ua.itea.lesson9;

public class Dog {
	private String name;
	private int age;
	private String breed;
	private Owner owner;
	
	{
//		System.out.println("Block1");
		//bread = "Terrier";
		String[] breeds = { "Terrier", "Chihuahua", "Dane" };
		breed = breeds[(int) (Math.random() * 3)];
		getInfo();
	}
	
	public Dog() {
		name = "Suslik";
		age = 5;	
	}
	
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;	
		getInfo();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	public String getName() {
		return "Barsik";
	}
	
	public void getInfo() {
		System.out.println("Name: " + name + "; Age: " + age
							+ "; Breed: " + breed + "; Owner: "
							+ ((owner == null) ? "<homeless>" : owner.getName()));
	}
}
