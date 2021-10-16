package leetcode.easy;

public class STRSTRPatternSearch {

	public static void main(String[] args) {
		String txt = "ABABDABACDABABCABAB";
		String pattern = "ABABCABAB";
		int index = strstr(txt, pattern);

		if (index == -1) {
			System.out.println("Pattern not fount");
		} else {
			System.out.println("Pattern found at start index:-> " + index);
		}
	}

	private static int strstr(String text, String pattern) {
		if (text == null || pattern == null) {
			return 0;
		}

		if (pattern.length() == 0) {
			return 0;
		}

		for (int i = 0; i < text.length(); i++) {
			if ((i + pattern.length()) > text.length()) {
				return -1;
			}

			int m = i;

			for (int j = 0; j < pattern.length(); j++) {
				if (pattern.charAt(j) == text.charAt(m)) {
					if (j == (pattern.length() - 1)) {
						return i;
					}
					m++;
				} else {
					break;
				}
			}
		}
		return -1;
	}
}
