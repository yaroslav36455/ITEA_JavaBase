package ua.itea.lesson07;

public class CatBox {
	int length = 3;
	int height = 3;
	int width  = 3;
	
	public void setLength(int l) {
		length = l;
	}
	
	public void printBox() {
		System.out.println("length:" + length);
		System.out.println("height:" + height);
		System.out.println("width :" + width);
	}
}
