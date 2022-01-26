package hashing;

import java.util.HashSet;

public class PairWithGivenSum {

	public static void main(String[] args) {
		int a[] = { 8, 4, 3, 9 };
		int sum = 13;

		boolean isPair = getPair(a, sum);
		System.out.println("Pair is Available:- " + isPair);
	}

	private static boolean getPair(int a[], int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			if (set.contains(sum - a[i])) {
				return true;
			} else {
				set.add(a[i]);
			}
		}
		return false;
	}
}
