package growkking.twopointerspattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletWithSmallerSum3 {

	public static void main(String[] args) {
		System.out.println(TripletWithSmallerSum3.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
		System.out.println(TripletWithSmallerSum3.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
	}

	private static List<List<Integer>> searchTriplets(int[] arr, int target) {
		if (arr == null || arr.length < 3) {
			throw new IllegalArgumentException();
		}

		Arrays.sort(arr);

		List<List<Integer>> triplets = new ArrayList<List<Integer>>();

		for (int i = 0; i < arr.length - 2; i++) {
			searchPair(arr, target - arr[i], i, triplets);
		}
		return triplets;
	}

	private static void searchPair(int[] arr, int targetSum, int first, List<List<Integer>> triplets) {
		int left = first + 1;
		int right = arr.length - 1;

		while (left < right) {
			if (arr[left] + arr[right] < targetSum) {
				for (int i = right; i > left; i--) {
					triplets.add(Arrays.asList(arr[first], arr[left], arr[i]));
				}
				left++;
			} else {
				right--;
			}
		}
	}
}
