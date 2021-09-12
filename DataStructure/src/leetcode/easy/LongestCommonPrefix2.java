package leetcode.easy;

public class LongestCommonPrefix2 {

	public static void main(String[] args) {
		String arr[] = { "geeksforgeeks", "geeks", "geek", "geezer" };

		String str = getLongestCommonPrefix(arr);
		System.out.println("Longest common prefix:-> " + str);
	}

	private static String getLongestCommonPrefix(String[] str) {
		if (str == null || str.length == 0) {
			return "";
		}
		if (str.length == 1) {
			return str[0];
		}

		String prefix = "";

		int index = findMinLength(str);

		int low = 0;
		int high = index - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (allContainsPrefix(str, str[0], low, mid)) {
				prefix = prefix + str[0].substring(low, mid + 1);
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return prefix;
	}

	private static int findMinLength(String[] strs) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() < min) {
				min = strs[i].length();
			}
		}
		return min;
	}

	private static boolean allContainsPrefix(String[] strs, String str, int start, int end) {
		for (int i = 0; i < str.length(); i++) {
			String strs_i = strs[i];

			for (int j = start; j <= end; j++) {
				if (strs_i.charAt(j) != str.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
}
