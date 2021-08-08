package leetcode.easy;

import java.util.Scanner;

public class ReverseDigit2 {
	private static int revNum = 0;
	private static int basePos = 1;
	private static int rem = 0;

	public static void main(String[] args) {
		System.out.println("Enater a number for reversal:-> ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		System.out.println("Reverse of no. is " + reversDigit(num));
	}

	private static int reversDigit(int num) {
		if (num > 0) {
			reversDigit(num / 10);
			rem = num % 10;
			revNum = revNum + rem * basePos;
			basePos = basePos * 10;
		}

		return revNum;
	}

}
