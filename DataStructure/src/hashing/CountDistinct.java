package hashing;

import java.util.HashSet;

public class CountDistinct {

	public static void main(String[] args) {
		int arr[] = { 15, 12, 13, 12, 13, 13, 18 };

		int distElement = countDistinct(arr);

		System.out.println("Total distinct Element:- " + distElement);
	}

	private static int countDistinct(int arr[]) {
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		return set.size();
	}
}
