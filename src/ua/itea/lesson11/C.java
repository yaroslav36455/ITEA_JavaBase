package ua.itea.lesson11;

public class C extends B {
	//String name = "I'm class C";
	
	public C() {
		System.out.println("Constructor C begin");
		name = "I'm class C";
		printName();
		System.out.println("Constructor C end");
	}
	
	@Override
	public void printName() {
		System.out.println("C.printName() begin");
		System.out.println(name);
		System.out.println("C.printName() end");
	}
}

