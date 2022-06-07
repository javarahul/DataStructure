package array;

import java.util.HashSet;

public class TripletSumToZero1 {

	public static void main(String[] args) {
		int arr[] = { -1, 0, 1, 2, -1, -4 };
		findTriplets(arr);
	}

	private static void findTriplets(int arr[]) {
		boolean found = false;
		for (int i = 0; i < arr.length - 1; i++) {
			HashSet<Integer> set = new HashSet<>();
			for (int j = i + 1; j < arr.length; j++) {
				int sum = -(arr[i] + arr[j]);
				if (set.contains(sum)) {
					System.out.println("[" + arr[i] + ", " + arr[j] + ", " + sum + "]");
					found = true;
				} else {
					set.add(arr[j]);
				}
			}
		}

		if (!found) {
			System.out.println("Triplets not exist");
		}
	}
}
