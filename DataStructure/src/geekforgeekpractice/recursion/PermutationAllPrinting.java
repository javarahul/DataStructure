public class PermutationAllPrinting {

	public static void main(String[] args) {
		String str = "ABC";
		char[] charStr = str.toCharArray();
		permute(charStr, 0);
	}

	private static void permute(char[] str, int index) {
		if (index == str.length - 1) {
			System.out.println(String.valueOf(str) + " ");
			return;
		}

		for (int i = index; i < str.length; i++) {
			swap(i, index, str);
			permute(str, index + 1);
			swap(i, index, str);
		}
	}

	private static void swap(int i, int j, char[] str) {
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}
}
