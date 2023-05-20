package geeksforgeeks.practice.array.string;

public class AnagramSearchInText {

	public static void main(String[] args) {
		String text = "geeksforgeeks";
		String pat = "frog";// "rseek";

		boolean result = isAnagramPresent(text, pat);
		if (result) {
			System.out.println("Present");
		} else {
			System.out.println("Not present");
		}
	}

	public static boolean isAnagramPresent(String text, String pat) {
		int n = text.length();
		int m = pat.length();
		for (int i = 0; i < n - m; i++) {
			if (isAnagram(pat, text, i)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isAnagram(String pat, String text, int i) {
		int count[] = new int[256];

		for (int j = 0; j < pat.length(); j++) {
			count[pat.charAt(j)]++;
			count[text.charAt(i + j)]--;
		}

		for (int j = 0; j < 256; j++) {
			if (count[j] != 0) {
				return false;
			}
		}
		return true;
	}
}
