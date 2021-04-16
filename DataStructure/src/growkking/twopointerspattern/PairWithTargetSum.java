package growkking.twopointerspattern;

public class PairWithTargetSum {

	public static void main(String[] args) {
		int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
		System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
		result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
		System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
	}

	private static int[] search(int[] arr, int targetSum) {
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			int currSum = arr[left] + arr[right];

			if (currSum == targetSum) {
				return new int[] { left, right };
			}

			if (currSum > targetSum) {
				right--;
			} else {
				left++;
			}
		}
		return new int[] { -1, -1 };
	}

}
