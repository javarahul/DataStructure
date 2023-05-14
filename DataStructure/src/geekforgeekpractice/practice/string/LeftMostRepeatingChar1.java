package geeksforgeeks.practice.array.string;

public class LeftMostRepeatingChar1 {

	public static void main(String[] args) {
		String str = "geeksforgeeks";

		int index = getLeftMostRepeastingChar(str);

		if (index > -1) {
			System.out.println("LeftMost repeating character is available and index is: " + index);
		} else {
			System.out.println("LeftMost repeating character is not available");
		}
	}

	private static int getLeftMostRepeastingChar(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					return i;
				}
			}
		}
		return -1;
	}
}
