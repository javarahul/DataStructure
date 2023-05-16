package geeksforgeeks.practice.array.string;

public class PatternSearchingNormal1 {

	public static void main(String[] args) {
		String txt = "I am Rahul Tripathi";
		String pattern = "Rahu";

		patternSearch(txt, pattern);
	}

	public static void patternSearch(String txt, String pattern) {
		int n = txt.length();
		int m = pattern.length();

		for (int i = 0; i < (n - m + 1); i++) {
			int j;
			for (j = 0; j < m; j++) {
				if (txt.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}
			if (j == m) {
				System.out.println("Pattern matching at index: " + i);
			}
		}
	}
}
