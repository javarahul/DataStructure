ackage recursion;

public class MinDiffSubsetSum {

	public static void main(String[] args) {
		int arr[] = { 3, 1, 4, 2, 2, 1 };
		int n = arr.length;

		int minDiff = findMinDiff(arr, n);
		System.out.println("Minimum difference is:-> " + minDiff);
	}

	private static int findMinDiff(int[] arr, int n) {
		int totalSum = 0;
		for (int i = 0; i < n; i++) {
			totalSum += arr[i];
		}
		return findMinDiffRec(arr, n, 0, totalSum);
	}

	private static int findMinDiffRec(int[] arr, int currIndex, int currSum, int totalSum) {
		if (currIndex == 0) {
			return Math.abs((totalSum - currSum) - currSum);
		}

		return Math.min(findMinDiffRec(arr, currIndex - 1, currSum + arr[currIndex - 1], totalSum),
				findMinDiffRec(arr, currIndex - 1, currSum, totalSum));
	}
}
