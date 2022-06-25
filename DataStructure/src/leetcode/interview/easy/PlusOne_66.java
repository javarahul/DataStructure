package leatcode.interview.easy;

public class PlusOne_66 {

	public static void main(String[] args) {
		int digits[] = { 9, 9, 9 };

		int[] result = plusOne(digits);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	private static int[] plusOne(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + carry;

			if (sum > 9) {
				carry = 1;
			} else {
				carry = 0;
			}

			digits[i] = sum % 10;
		}

		if (carry > 0) {
			int result[] = new int[digits.length + 1];
			System.arraycopy(digits, 0, result, 1, digits.length);
			result[0] = 1;
			return result;
		} else {
			return digits;
		}
	}
}
