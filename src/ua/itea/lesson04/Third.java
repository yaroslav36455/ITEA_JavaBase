package ua.itea.lesson04;

public class Third {

	int i;
	
	public static void main(String[] args) {
		System.out.println(new Third().i);
		Byte b;
		int a = 10;
		Integer aa = a;
		System.out.println(aa);
		
		Double dd = Double.valueOf(a);
		int[] array  = new int[5];
		int[] array2 = {1, 2, 3};
		System.out.println(array2[1]);
//		System.out.println(array2[5]);
		System.out.println("-------------------------");
		
		for(int i = 0; i < array2.length; i++) {
			System.out.println(array2[i]);
		}
		
		char[] array3 = new char[5];
		char[] array4 = {'A', 'B', 'C'};
		
		for(int i = 0; i < array3.length; i++) {
			array3[i] = (char) ((int) (Math.random() * (123 - 65) + 65));
			System.out.print(array3[i] + " ");
		}
	}

}
