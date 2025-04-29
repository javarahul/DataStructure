package geeksforgeeks.batch.recursion;

public class Permutation {

	public static void main(String[] args) {
		String str = "ABC";
		permute(str, 0, str.length() - 1);
	}

	private static void permute(String str, int l, int r) {
		if (l == r) {
			System.out.println(str + " ");
			return;
		} else {
			for (int i = l; i <= r; i++) {
				str = new String(swap(str, i, l));
				permute(str, l + 1, r);
				str = new String(swap(str, i, l));
			}
		}
	}

	private static char[] swap(String str, int i, int j) {
		char ch[] = str.toCharArray();
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
		return ch;
	}
}
