package geeksforgeeks.practice.array.string;

public class AnagramSearchInText1 {
	private static int CHAR = 256;

	public static void main(String[] args) {
		String txt = "geeksforgeeks";
		String pat = "frog";// "rseek";
		if (isPresent(txt, pat)) {
			System.out.println("Anagram search found");
		} else {
			System.out.println("Anagram search not found");
		}
	}

	public static boolean isPresent(String txt, String pat) {
		int CT[] = new int[CHAR];
		int CP[] = new int[CHAR];

		for (int i = 0; i < pat.length(); i++) {
			CT[txt.charAt(i)]++;
			CP[pat.charAt(i)]++;
		}

		for (int i = pat.length(); i < txt.length(); i++) {
			if (isSame(CT, CP)) {
				return true;
			}
			CT[txt.charAt(i)]++;
			CT[txt.charAt(i - pat.length())]--;
		}

		return false;
	}

	private static boolean isSame(int[] cT, int[] cP) {
		for (int i = 0; i < CHAR; i++) {
			if (cT[i] != cP[i]) {
				return false;
			}
		}
		return true;
	}
}
