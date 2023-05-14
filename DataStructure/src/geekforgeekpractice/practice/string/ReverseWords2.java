package geeksforgeeks.practice.array.string;

import java.util.Stack;

public class ReverseWords2 {

	public static void main(String[] args) {
		String str = " I   am Rahul Kumar Tripathi ";

		String result = getReverseWords(str);

		System.out.println(result);
	}

	public static String getReverseWords(String str) {
		char[] strArray = str.toCharArray();
		int len = strArray.length;

		int start = 0;
		for (int end = 0; end < len; end++) {
			if (strArray[end] == ' ') {
				reverse(strArray, start, end - 1);
				start = end + 1;
			}
		}
		reverse(strArray, start, len - 1);
		reverse(strArray, 0, len - 1);

		return String.valueOf(strArray);
	}

	private static void reverse(char[] strArray, int low, int high) {
		while (low <= high) {
			char temp = strArray[low];
			strArray[low] = strArray[high];
			strArray[high] = temp;
			low++;
			high--;
		}
	}

}
