package leetcode.easy;

import java.util.Scanner;

public class ReverseDigit3 {

	public static void main(String[] args) {
		System.out.println("Enater a number for reversal:-> ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		System.out.println("Reverse of no. is " + reversDigit(num));
	}

	private static int reversDigit(int num) {
		boolean flag = false;
		if (num < 0) {
			num = 0 - num;
			flag = true;
		}
		int revNum = 0;
		int prevRevNum = 0;
		while (num > 0) {
			int rem = num % 10;
			revNum = revNum * 10 + rem;
			if ((revNum - rem) / 10 != prevRevNum) {
				return 0;
			}
			prevRevNum = revNum;
			num = num / 10;
		}
		if (flag) {
			revNum = 0 - revNum;
		}
		return revNum;
	}
}
