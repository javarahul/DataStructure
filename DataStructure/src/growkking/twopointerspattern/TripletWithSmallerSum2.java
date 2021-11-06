package growkking.twopointerspattern;

import java.util.Arrays;

public class TripletWithSmallerSum2 {

	public static void main(String[] args) {
		System.out.println(TripletWithSmallerSum2.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
		System.out.println(TripletWithSmallerSum2.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
	}

	private static int searchTriplets(int[] arr, int target) {
		if (arr == null || arr.length < 3) {
			throw new IllegalArgumentException();
		}

		Arrays.sort(arr);

		int count = 0;

		for (int i = 0; i < arr.length - 2; i++) {
			count += searchPair(arr, target - arr[i], i);
		}
		return count;
	}

	private static int searchPair(int[] arr, int targetSum, int i) {
		int count = 0;
		int left = i + 1;
		int right = arr.length - 1;

		while (left < right) {
			if (arr[left] + arr[right] < targetSum) {
				count += right - left;
				left++;
			}else {
				right--;
			}
		}
		return count;
	}
}
