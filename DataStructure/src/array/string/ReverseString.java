package array.string;

public class ReverseString {

	public static void main(String[] args) {
		String s = "i like this program very much ";
		char[] p = reverseWords(s.toCharArray());
		System.out.print(p);
	}

	private static char[] reverseWords(char[] str) {
		int start = 0;

		for (int end = 0; end < str.length; end++) {
			if (str[end] == ' ') {
				reverse(str, start, end - 1);
				start = end + 1;
			}
		}

		reverse(str, start, str.length - 1);
		reverse(str, 0, str.length - 1);

		return str;
	}

	private static void reverse(char[] str, int start, int end) {
		while (start < end) {
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}
}
