package leetcode.easy;

import java.util.Scanner;

public class ReverseDigit1 {

	public static void main(String[] args) {
		System.out.println("Enater a number for reversal:-> ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		System.out.println("Reverse of no. is " + reversDigit(num));
	}

	private static int reversDigit(int num) {
		int revNum = 0;

		while (num > 0) {
			int rem = num % 10;
			revNum = revNum * 10 + rem;
			num = num / 10;
		}

		return revNum;
	}

}
