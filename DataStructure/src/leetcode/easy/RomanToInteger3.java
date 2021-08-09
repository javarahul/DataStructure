package leetcode.easy;

import java.util.Scanner;

public class RomanToInteger3 {

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

		int[] nums = new int[romanNum.length()];

		for (int i = 0; i < romanNum.length(); i++) {
			switch (romanNum.charAt(i)) {
			case 'I':
				nums[i] = 1;
				break;
			case 'V':
				nums[i] = 5;
				break;
			case 'X':
				nums[i] = 10;
				break;
			case 'L':
				nums[i] = 50;
				break;
			case 'C':
				nums[i] = 100;
				break;
			case 'D':
				nums[i] = 500;
				break;
			case 'M':
				nums[i] = 1000;
				break;
			default:
				break;
			}
		}

		int sum = 0;

		for (int i = 0; i < romanNum.length()-1; i++) {
			if (nums[i] < nums[i + 1]) {
				sum -= nums[i];
			} else {
				sum += nums[i];
			}
		}
		return sum + nums[romanNum.length() - 1];
	}
}
