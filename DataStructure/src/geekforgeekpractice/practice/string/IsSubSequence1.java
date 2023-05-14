package geeksforgeeks.practice.array.string;

public class IsSubSequence1 {

	public static void main(String[] args) {
		String s1 = "ABCDEF";
		String s2 = "ADE";

		boolean isSubSeq = isSubSequence(s1, s2, s1.length(), s2.length());

		if (isSubSeq) {
			System.out.println("String is subseqence");
		} else {
			System.out.println("String is not subseqence");
		}
	}

	private static boolean isSubSequence(String s1, String s2, int n, int m) {
		if (n < m) {
			return false;
		}
		int j = 0;
		for (int i = 0; i < n && j < m; i++) {
			if (s1.charAt(i) == s2.charAt(j)) {
				j++;
			}
		}
		return (j == m);
	}
}
