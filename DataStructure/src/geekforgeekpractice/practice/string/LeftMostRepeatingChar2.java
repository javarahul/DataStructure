package geeksforgeeks.practice.array.string;

public class LeftMostRepeatingChar2 {

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
		int count[] = new int[256];
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i)]++;
		}
		for (int i = 0; i < str.length(); i++) {
			if (count[str.charAt(i)] > 1) {
				return i;
			}
		}
		return -1;
	}
}
