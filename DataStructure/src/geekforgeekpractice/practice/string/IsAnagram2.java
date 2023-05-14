package geeksforgeeks.practice.array.string;

public class IsAnagram2 {
	private static final int CHAR = 256;

	public static void main(String[] args) {
		String s1 = "listen";
		String s2 = "silent";

		boolean isAnagram = isAnagram(s1, s2);

		if (isAnagram) {
			System.out.println("Given string is Anagram");
		} else {
			System.out.println("Given string is not Anagram");
		}
	}

	public static boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		int count[] = new int[CHAR];

		for (int i = 0; i < s1.length(); i++) {
			count[s1.charAt(i)]++;
			count[s2.charAt(i)]--;
		}

		for (int i = 0; i < CHAR; i++) {
			if (count[i] != 0) {
				return false;
			}
		}

		return true;
	}
}
