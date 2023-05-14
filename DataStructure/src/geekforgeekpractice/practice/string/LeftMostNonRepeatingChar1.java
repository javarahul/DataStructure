package geeksforgeeks.practice.array.string;

public class LeftMostNonRepeatingChar1 {
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
		for (int i = 0; i < str.length(); i++) {
			boolean flag = false;
			for (int j = 0; j < str.length(); j++) {
				if (i != j && str.charAt(i) == str.charAt(j)) {
					flag = true;
					break;
				}
			}

			if (flag == false) {
				return i;
			}
		}
		return -1;
	}
}
