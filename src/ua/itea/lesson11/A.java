package ua.itea.lesson11;

public class A {
	protected String name = "I'm class A";
	
	public A() {
		System.out.println("Constructor A begin");
		printName();
		System.out.println("Constructor A end");
	}
	
	public void printName() {
		System.out.println("A.printName() begin");
		System.out.println(name);
		System.out.println("A.printName() end");
	}
}
