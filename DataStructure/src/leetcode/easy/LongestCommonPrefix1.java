package leetcode.easy;

public class LongestCommonPrefix1 {

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

		int i = 0;
		while (true) {
			boolean flag = true;
			for (int j = 1; j < str.length; j++) {
				if (str[j].length() <= i || str[j - 1].length() <= i || str[j].charAt(i) != str[j - 1].charAt(i)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				i++;
			} else {
				break;
			}
		}

		return str[0].substring(0, i);
	}
}
