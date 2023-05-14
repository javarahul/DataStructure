package geeksforgeeks.practice.array.string;

import java.util.Arrays;

public class isAnagram1 {

	public static void main(String[] args) {
		String s1 = "listen";
		String s2 = "silent";

		boolean isAnagram = isAnagram(s1, s2);

		if (isAnagram) {
			System.out.println("Given string is Anagram");
		} else {
			System.out.println("Given string is not Anagram");
		}
	}

	public static boolean isAnagram(String s1, String s2) {
		char[] s1Char = s1.toCharArray();
		Arrays.sort(s1Char);

		char[] s2Char = s2.toCharArray();
		Arrays.sort(s2Char);

		return (String.valueOf(s1Char).equals(String.valueOf(s2Char)));
	}
}
