package standardalgorithm;

public class KMPPatternSearchAlgo {

	public static void main(String[] args) {
		String txt = "ABABDABACDABABCABAB";
		String pattern = "ABABCABAB";

		KMPPatternSearchAlgo algo = new KMPPatternSearchAlgo();
		algo.kmpSearchAlgo(txt, pattern);
	}

	private void kmpSearchAlgo(String txt, String pattern) {
		int M = pattern.length();
		int N = txt.length();

		int longestPrefixSuffix[] = new int[M];
		computelps(pattern, M, longestPrefixSuffix);

		int j = 0; // index for pattern
		int i = 0; // index for txt string

		while (i < N) {
			if (pattern.charAt(j) == txt.charAt(i)) {
				i++;
				j++;
			}

			if (j == M) {
				System.out.println("Pattern Matches at index:- " + (i - j));
				j = longestPrefixSuffix[j - 1];
			}

			else if (i < N && txt.charAt(i) != pattern.charAt(j)) {
				if (j != 0) {
					j = longestPrefixSuffix[j - 1];
				} else {
					i = i + 1;
				}
			}
		}
	}

	private void computelps(String pattern, int m, int[] longestPrefixSuffix) {
		int len = 0;
		int i = 1;
		longestPrefixSuffix[0] = 0;

		while (i < m) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				longestPrefixSuffix[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = longestPrefixSuffix[len - 1];
				} else {
					longestPrefixSuffix[i] = len;
					i++;
				}
			}
		}
	}
}
