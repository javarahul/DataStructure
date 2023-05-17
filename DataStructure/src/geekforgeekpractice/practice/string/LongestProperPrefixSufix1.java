package geeksforgeeks.practice.array.string;

public class LongestProperPrefixSufix1 {
	public static void main(String args[]) {
		String txt = "abacabad";
		int[] lps = new int[txt.length()];
		fillLPS(txt, lps);
		for (int i = 0; i < txt.length(); i++) {
			System.out.print(lps[i] + " ");
		}
	}

	public static void fillLPS(String txt, int[] lps) {
		for (int i = 0; i < txt.length(); i++) {
			lps[i] = longPropPrefSuff(txt, i + 1);
		}
	}

	private static int longPropPrefSuff(String txt, int n) {
		for (int len = n - 1; len > 0; len--) {
			boolean flag = true;
			for (int i = 0; i < len; i++) {
				if (txt.charAt(i) != txt.charAt(n - len + i)) {
					flag = false;
				}
			}
			if (flag) {
				return len;
			}
		}
		return 0;
	}
}
