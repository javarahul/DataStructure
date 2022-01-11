package hashing;

import java.util.HashSet;

public class IntersectionTwoArrayNaive {

	public static void main(String[] args) {
		int a[] = { 10, 20, 10, 30, 20 };
		int b[] = { 20, 10, 10, 40 };

		int result = findIntersection(a, b);

		System.out.println("Distinct intersection:- " + result);
	}

	private static int findIntersection(int a[], int b[]) {
		int result = 0;
		HashSet<Integer> set = new HashSet<Integer>();

		for (int x : a) {
			set.add(x);
		}

		for (int x : b) {
			if (set.contains(x)) {
				result++;
				set.remove(x);
			}
		}
		return result;
	}
}
