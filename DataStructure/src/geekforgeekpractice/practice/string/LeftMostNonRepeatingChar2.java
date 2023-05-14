package geeksforgeeks.practice.array.string;

public class LeftMostNonRepeatingChar2 {
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
		int count[] = new int[256];
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i)]++;
		}

		for (int i = 0; i < str.length(); i++) {
			if (count[str.charAt(i)] == 1) {
				return i;
			}
		}
		return -1;
	}
}
