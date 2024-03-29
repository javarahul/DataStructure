package growkking.twopointerspattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {

	public static void main(String[] args) {
		System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
		System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
	}

	private static List<List<Integer>> searchTriplets(int[] arr) {
		Arrays.sort(arr);

		List<List<Integer>> triplets = new ArrayList<List<Integer>>();

		for (int i = 0; i < arr.length - 2; i++) {
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			searchPair(arr, -arr[i], i + 1, triplets);
		}
		return triplets;
	}

	private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
		int right = arr.length - 1;
		while (left < right) {
			int currSum = arr[left] + arr[right];
			if (currSum == targetSum) {
				triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
				left++;
				right--;
				while (left < right && arr[left] == arr[left - 1]) {
					left++;
				}
				while (left < right && arr[right] == arr[right + 1]) {
					right--;
				}
			} else if (targetSum > currSum) {
				left++;
			} else {
				right--;
			}
		}
	}
}
