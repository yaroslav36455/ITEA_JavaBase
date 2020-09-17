package ua.itea.lesson04;

public class Second {

	public static void main(String[] args) throws InterruptedException {
//		for (int i = 10; i > 0; i--) {
//			Thread.sleep(1000);
//			System.out.print(i + "\r ");
//		}

		int time = 7563;
		int h, m, s;
		while (time > 0) {
			
			h = time / 3600;
			m = time % 3600 / 60;
			s = time % 3600 % 60;
			System.out.print(((h) < 10 ? "0" : "") + h + ":"
					         + ((m) < 10 ? "0" : "") + m + ":"
					         + ((s) < 10 ? "0" : "") + s + "\r");
			Thread.sleep(1000);
			time--;
		}
	}

}
