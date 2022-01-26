package hashing;

import java.util.HashSet;

public class UnionForUnsortedArray {

	public static void main(String[] args) {
		int a[] = { 10, 30, 10, 18, 30, 20 };
		int b[] = { 5, 10, 5, 15 };

		int result = getDistUnion(a, b);

		System.out.println("Union of 2 unsorted Arrays: " + result);
	}

	private static int getDistUnion(int a[], int b[]) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i:a) {
			set.add(i);
		}

		for(int i:b) {
			set.add(i);
		}
		return set.size();
	}
}
