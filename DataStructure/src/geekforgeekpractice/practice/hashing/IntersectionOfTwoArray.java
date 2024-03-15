package geekforgeekpractice.practice.hashing;

import java.util.HashSet;

public class IntersectionOfTwoArray {

	public static void main(String[] args) {
		int a[] = { 10, 20, 30 };
		int b[] = { 10, 30 };

		printIntersection(a, b);
	}

	private static void printIntersection(int[] a, int[] b) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < b.length; i++) {
			set.add(b[i]);
		}
		for (int i = 0; i < a.length; i++) {
			if (set.contains(a[i])) {
				System.out.println(a[i] + " ");
			}
		}
	}
}
