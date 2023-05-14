package geeksforgeeks.practice.array.string;

import java.util.Arrays;

public class LeftMostNonRepeatingChar3 {
	public static void main(String args[]) {
		String str = "geeksforgeeks";
		int index = getIndexOfLeftMostNonRepeatingChar(str);

		if (index == -1) {
			System.out.println("No non repeating character present in given string");
		} else {
			System.out.println("First LeftMost Non Repeating character index is: " + index + " and character is: "
					+ str.charAt(index));
		}
	}

	public static int getIndexOfLeftMostNonRepeatingChar(String str) {
		int firstIndexArray[] = new int[256];
		Arrays.fill(firstIndexArray, -1);

		for (int i = 0; i < str.length(); i++) {
			if (firstIndexArray[str.charAt(i)] == -1) {
				firstIndexArray[str.charAt(i)] = i;
			} else {
				firstIndexArray[str.charAt(i)] = -2;
			}
		}

		int result = Integer.MAX_VALUE;

		for (int i = 0; i < 256; i++) {
			if (firstIndexArray[i] >= 0) {
				if (result > firstIndexArray[i]) {
					result = firstIndexArray[i];
				}
			}
		}

		return (result == Integer.MAX_VALUE) ? -1 : result;
	}
}
