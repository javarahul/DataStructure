package geeksforgeeks.practice.array.string;

import java.util.Arrays;

public class LeftMostRepeatingChar4 {

	public static void main(String[] args) {
		String str = "abccbd";// "geeksforgeeks";

		int index = getLeftMostRepeastingChar(str);

		if (index > -1) {
			System.out.println("LeftMost repeating character is available and index is: " + index);
		} else {
			System.out.println("LeftMost repeating character is not available");
		}
	}

	private static int getLeftMostRepeastingChar(String str) {
		boolean visited[] = new boolean[256];

		int result = -1;
		for (int i = str.length() - 1; i >= 0; i--) {
			if (visited[str.charAt(i)]) {
				result = i;
			} else {
				visited[str.charAt(i)] = true;
			}
		}
		return result;
	}
}
