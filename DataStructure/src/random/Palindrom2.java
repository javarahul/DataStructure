package random;

import java.util.Scanner;

public class Palindrom2 {
	public static void main(String[] str) {
		System.out.println("Enter the number for checking palindrom:-> ");
		Scanner sc = new Scanner(System.in);
		long num = sc.nextInt();
		long temp = num;
		long reverseNum = reverseNumber(num);
		if (temp == reverseNum) {
			System.out.println("This num = " + num + " is Palindrom");
		} else {
			System.out.println("This num = " + num + " is not Palindrom");
		}
	}

	private static long reverseNumber(long num) {
		long rem, rev = 0;
		while (num != 0) {
			rem = num % 10;
			rev = rev * 10 + rem;
			num = num / 10;
		}
		return rev;
	}
}
