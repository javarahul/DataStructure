package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero2 {

	public static void main(String[] args) {
		int arr[] = { -1, 0, 1, 2, -1, -4 };

		/*
		 * System.out.println("Before Sorting"); for (int arrItem : arr) {
		 * System.out.print(arrItem + " "); }
		 */

		mergesort(arr, 0, arr.length - 1);

		/*
		 * System.out.println(); System.out.println("After Sorting"); for (int arrItem :
		 * arr) { System.out.print(arrItem + " "); }
		 */

		List<List<Integer>> triplets = new ArrayList<List<Integer>>();

		for (int i = 0; i < arr.length - 2; i++) {
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			findTriplets(arr, -arr[i], i + 1, triplets);
		}

		System.out.println(triplets);
	}

	private static void mergesort(int arr[], int low, int high) {
		if (low >= high) {
			return;
		}

		int mid = low + (high - low) / 2;

		mergesort(arr, low, mid);
		mergesort(arr, mid + 1, high);

		merge(arr, low, mid, high);
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int temp[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}

		int i = low;
		int j = mid + 1;
		int k = low;

		while (i <= mid && j <= high) {
			if (temp[i] <= temp[j]) {
				arr[k] = temp[i++];
			} else {
				arr[k] = temp[j++];
			}
			k++;
		}

		while (i <= mid) {
			arr[k++] = temp[i++];
		}

		while (j <= high) {
			arr[k++] = temp[j++];
		}
	}

	private static void findTriplets(int arr[], int targetSum, int left, List<List<Integer>> triplets) {
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
