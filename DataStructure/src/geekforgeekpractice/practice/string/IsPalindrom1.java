package geeksforgeeks.practice.array.string;

public class IsPalindrom1 {

	public static void main(String[] args) {
		String str = "Rahul";// "ABCDCBA";

		boolean isPalindrom = isPalindrom(str);
		if (isPalindrom) {
			System.out.println("GIven string is palindrom");
		} else {
			System.out.println("GIven string is not palindrom");
		}
	}

	private static boolean isPalindrom(String str) {
		String revString = reverseString(str);
		System.out.println(revString);
		if (str.equals(revString)) {
			return true;
		}
		return false;
	}

	private static String reverseString(String str) {
		char[] strArray = str.toCharArray();
		int low = 0;
		int high = str.length() - 1;
		while (low < high) {
			char temp = strArray[low];
			strArray[low] = strArray[high];
			strArray[high] = temp;
			low++;
			high--;
		}
		return String.valueOf(strArray)/* new String(strArray) */;
	}

}
