package geeksforgeeks.recursion;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		System.out.println("Enter a String:-> ");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		if (checkPalindrom(str, 0, str.length() - 1)) {
			System.out.println("This string:-> " + str + " is a " + "Palindrome");
		} else {
			System.out.println("This string:-> " + str + " is not a " + "Palindrome");
		}
	}

	private static boolean checkPalindrom(String str, int start, int end) {
		if (start >= end) {
			return true;
		}
		return (str.charAt(start) == str.charAt(end) && checkPalindrom(str, start + 1, end - 1));
	}
}
