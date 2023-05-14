package geeksforgeeks.practice.array.string;

public class IsSubSequence2 {

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
		if (m == 0) {
			return true;
		}

		if (n == 0) {
			return false;
		}

		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			return isSubSequence(s1, s2, n - 1, m - 1);
		} else {
			return isSubSequence(s1, s2, n - 1, m);
		}
	}
}
