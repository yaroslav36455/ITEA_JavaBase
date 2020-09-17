package ua.itea.lesson04.tasks;

public class Task2 {
	public static void main(String[] args) {
		char[] word = { 'м', 'а', 'д', 'а', 'м' };
		boolean isPalindrome = true;
		
		for (int i = 0; i < word.length / 2; i++) {
			if (word[i] != word[word.length - 1 - i]) {
				isPalindrome = false;
				break;
			}
		}

		/* Output */
		System.out.println("Слово \"" + new String(word) + "\""
		                   + (isPalindrome ? " " : " НЕ ")
		                   + "является палиндромом.");
	}
}
