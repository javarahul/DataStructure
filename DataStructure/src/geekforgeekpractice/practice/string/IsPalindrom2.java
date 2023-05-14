package geeksforgeeks.practice.array.string;

public class IsPalindrom2 {

	public static void main(String[] args) {
		String str = "ABCDCBA";

		boolean isPalindrom = isPalindrom(str);
		if (isPalindrom) {
			System.out.println("GIven string is palindrom");
		} else {
			System.out.println("GIven string is not palindrom");
		}
	}

	private static boolean isPalindrom(String str) {
		int low = 0;
		int high = str.length() - 1;
		while (low < high) {
			if (str.charAt(low) != str.charAt(high)) {
				return false;
			}
			low++;
			high--;
		}
		return true;
	}

}
