package leetcode.easy;

import java.util.HashMap;
import java.util.Scanner;

public class RomanToInteger2 {

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

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int num = 0;

		for (int i = 0; i < romanNum.length(); i++) {
			if (i <= romanNum.length() - 2 && map.get(romanNum.charAt(i)) < map.get(romanNum.charAt(i + 1))) {
				num = num - map.get(romanNum.charAt(i));
			} else {
				num = num + map.get(romanNum.charAt(i));
			}
		}
		return num;
	}
}
