package hashing;

public class PairWithGivenSum {

	public static void main(String[] args) {
		int a[] = { 8, 4, 3, 9 };
		int sum = 13;

		boolean isPair = getPair(a, sum);
		System.out.println("Pair is Available:- " + isPair);
	}

	private static boolean getPair(int a[], int sum) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] + a[j] == sum) {
					return true;
				}
			}
		}
		return false;
	}
}
