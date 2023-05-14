package geeksforgeeks.practice.array.string;

import java.util.Arrays;

public class LeftMostRepeatingChar3 {

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
		int resultIndex = Integer.MAX_VALUE;

		int[] firstIndex = new int[256];
		Arrays.fill(firstIndex, -1);

		for (int i = 0; i < str.length(); i++) {
			int fi = firstIndex[str.charAt(i)];

			if (fi == -1) {// Non repeated character
				firstIndex[str.charAt(i)] = i;
			} else {// Repeated charater now need to check index is min or not for left most
				if (resultIndex > fi) {
					resultIndex = fi;
				}
			}
		}

		if (resultIndex == Integer.MAX_VALUE) {
			return -1;
		} else {
			return resultIndex;
		}
	}
}
