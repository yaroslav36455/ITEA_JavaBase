package ua.itea.lesson08;

public class Lamp {
	private boolean state;
	private int brightness;
	
	void setBrightness(int brightness) {
		this.brightness = brightness;
		if (brightness == 0) {
			state = false;
		} else {
			state = true;
		}
	}
	
	void printInfo() {
		System.out.println("light: " + (state ? "ON" : "OFF")
						   + "; brightness: " + brightness);
	}
	
	public void doSomething() {
		System.out.println("default");
	}
	
	public void doSomething(int i) {
		System.out.println("int");
	}
	
	public void doSomething(double i) {
		System.out.println("double");
	}
	
	public void doSomething(double i, int y) {
		System.out.println("double-int");
	}
	
	public void doSomething(int y, double i) {
		System.out.println("int-double");
	}
	
	public void doSomethingElse(int a, int b, int ...varg) {
		for (int i = 0; i < varg.length; i++) {
			System.out.println("varg[" + i + "]=" + varg[i]);
		}
	}
	
	public void doSomethingElse(int[] arr, int a) {
		
	}
	
	public int getA() {
		int i = 5;
		return i;
	}
}
