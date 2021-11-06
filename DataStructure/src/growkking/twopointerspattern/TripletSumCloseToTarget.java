package growkking.twopointerspattern;

import java.util.Arrays;

public class TripletSumCloseToTarget {

	public static void main(String[] args) {
		System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
		System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
		System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
	}

	private static int searchTriplet(int[] arr, int targetSum) {
		if (arr == null || arr.length < 3) {
			throw new IllegalArgumentException();
		}

		Arrays.sort(arr);

		int smallestDiff = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length - 2; i++) {
			int left = i + 1;
			int right = arr.length - 1;

			while (left < right) {
				int currTripletSum = arr[i] + arr[left] + arr[right];

				if (Math.abs(targetSum - currTripletSum) < Math.abs(targetSum - smallestDiff)) {
					smallestDiff = currTripletSum;
				}

				if (currTripletSum > targetSum) {
					right--;
				} else {
					left++;
				}
			}
		}
		return (int) smallestDiff;
	}
}
