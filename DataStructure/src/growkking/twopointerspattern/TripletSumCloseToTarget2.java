package growkking.twopointerspattern;

import java.util.Arrays;

public class TripletSumCloseToTarget2 {

	public static void main(String[] args) {
		System.out.println(TripletSumCloseToTarget2.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
		System.out.println(TripletSumCloseToTarget2.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
		System.out.println(TripletSumCloseToTarget2.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
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
				int targerDiff = targetSum - currTripletSum;

				if (targerDiff == 0) {
					return targetSum - targerDiff;
				}
				if (Math.abs(targerDiff) < Math.abs(smallestDiff)
						|| (Math.abs(targerDiff) == Math.abs(smallestDiff)) && targerDiff > smallestDiff) {
					smallestDiff = targerDiff;
				}

				if (targerDiff > 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return targetSum - smallestDiff;
	}
}
