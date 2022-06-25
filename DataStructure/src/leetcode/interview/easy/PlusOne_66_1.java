package leatcode.interview.easy;

public class PlusOne_66_1 {

	public static void main(String[] args) {
		int digits[] = { 1, 9, 9 };

		int[] result = plusOne(digits);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	private static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}

		int[] result = new int[digits.length + 1];
		result[0] = 1;
		return result;
	}
}
