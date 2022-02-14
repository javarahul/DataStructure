package geeksforgeeks.recursion;

public class SumOfDigits {
	public static void main(String[] args) {
		System.out.println(getSumOfDigit(253));
	}

	private static int getSumOfDigit(int n) {
		if (n == 0) {
			return 0;
		}
		return getSumOfDigit(n / 10) + n % 10;
	}
}
