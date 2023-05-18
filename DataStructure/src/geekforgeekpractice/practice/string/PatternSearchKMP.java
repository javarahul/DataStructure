package geeksforgeeks.practice.array.string;

public class PatternSearchKMP {
	public static void main(String[] args) {
		String txt = "ababcababaad", pat = "ababa";
		KMP(pat, txt);
	}

	public static void KMP(String pat, String txt) {
		int n = txt.length();
		int m = pat.length();
		int lps[] = new int[m];
		fillLps(pat, lps);
		int i = 0;
		int j = 0;
		while (i < n) {
			if (txt.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			}
			if (j == m) {
				System.out.println("Pattern found: " + (i - j));
				j = lps[j - 1];
			} else if (i < n && txt.charAt(i) != pat.charAt(j)) {
				if (j == 0) {
					i++;
				} else {
					j = lps[j - 1];
				}
			}
		}
	}

	private static void fillLps(String pat, int[] lps) {
		int n = pat.length();
		int len = 0;
		lps[0] = 0;
		int i = 1;
		while (i < n) {
			if (pat.charAt(i) == pat.charAt(len)) {
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
