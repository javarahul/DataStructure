package geeksforgeeks.practice.array.string;

public class LongestProperPrefixSufix2 {
	public static void main(String args[]) {
		String txt = "abacabad";
		int[] lps = new int[txt.length()];
		fillLPS(txt, lps);
		for (int i = 0; i < txt.length(); i++) {
			System.out.print(lps[i] + " ");
		}
	}

	public static void fillLPS(String txt, int[] lps) {
		int n = txt.length();
		lps[0] = 0;
		int len = 0; // LPS of previous that means i-1
		int i = 1; // Because i = 0 already filled in above steps
		while (i < n) {
			if (txt.charAt(i) == txt.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len == 0) {
					lps[i] = 0;
					i++;
				} else {
					len = lps[len - 1];
				}
			}
		}
	}
}
