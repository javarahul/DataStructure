package leetcode.easy;

import java.util.Scanner;

public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println("Enter a Roman Number:-> ");

		Scanner sc = new Scanner(System.in);
		String romanNum = sc.next();

		int num = romanToInt(romanNum);

		System.out.println("Number of given Roman:-> " + num);
	}

	private static int romanToInt(String romanNum) {

		if (romanNum == null || romanNum.isEmpty()) {
			return 0;
		}

		int num = 0;
		int i = 0;

		while (i < romanNum.length()) {
			if (i <= romanNum.length() - 2 && romanNum.charAt(i) == 'I' && romanNum.charAt(i + 1) == 'V') {
				num += 4;
				i += 2;
			} else if (i <= romanNum.length() - 2 && romanNum.charAt(i) == 'X' && romanNum.charAt(i + 1) == 'L') {
				num += 40;
				i += 2;
			} else if (i <= romanNum.length() - 2 && romanNum.charAt(i) == 'C' && romanNum.charAt(i + 1) == 'D') {
				num += 400;
				i += 2;
			} else if (i <= romanNum.length() - 2 && romanNum.charAt(i) == 'I' && romanNum.charAt(i + 1) == 'X') {
				num += 9;
				i += 2;
			} else if (i <= romanNum.length() - 2 && romanNum.charAt(i) == 'X' && romanNum.charAt(i + 1) == 'C') {
				num += 90;
				i += 2;
			} else if (i <= romanNum.length() - 2 && romanNum.charAt(i) == 'C' && romanNum.charAt(i + 1) == 'M') {
				num += 900;
				i += 2;
			} else {
				num += toInteger(romanNum.charAt(i));
				i++;
			}
		}
		return num;
	}

	private static int toInteger(char ch) {
		int num = 0;
		switch (ch) {
		case 'I':
			num = 1;
			break;
		case 'V':
			num = 5;
			break;
		case 'X':
			num = 10;
			break;
		case 'L':
			num = 50;
			break;
		case 'C':
			num = 100;
			break;
		case 'D':
			num = 500;
			break;
		case 'M':
			num = 1000;
			break;
		default:
			break;
		}
		return num;
	}
}
