package ua.itea.lesson11;

public class B extends A {
	//String name = "I'm class B";
	
	public B() {
		System.out.println("Constructor B begin");
		name = "I'm class B";
		printName();
		System.out.println("Constructor B end");
	}
	
	@Override
	public void printName() {
		System.out.println("B.printName() begin");
		System.out.println(name);
		System.out.println("B.printName() end");
	}
}