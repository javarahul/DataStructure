package random;

import java.util.Scanner;

public class Palindrom {
	public static void main(String[] str) {
		System.out.println("Enter the number for checking palindrom:-> ");
		Scanner sc = new Scanner(System.in);
		long num = sc.nextInt();

		if (isPalindrom(num)) {
			System.out.println("This num = " + num + " is Palindrom");
		} else {
			System.out.println("This num = " + num + " is not Palindrom");
		}
	}

	private static boolean isPalindrom(long num) {
		long diviser = 1;

		while (num / diviser >= 10) {
			diviser *= 10;
		}
		while (num != 0) {
			long leading = num / diviser;
			long trailing = num % 10;

			if (leading != trailing)
				return false;

			num = (num % diviser) / 10;

			diviser = diviser / 100;
		}
		return true;
	}
}
