package recursion;

public class CountNoOfSubsetGivenDifference {

	public static void main(String[] args) {
		int arr[] = { 1, 1, 2, 3 };
		int diff = 1;
		int n = arr.length;
		int arrSum = 0;
		for (int i = 0; i < n; i++) {
			arrSum += arr[i];
		}

		int sum = (diff + arrSum) / 2;

		System.out.println(findCnt(arr, sum, n));
	}

	private static int findCnt(int[] arr, int sum, int n) {
		if (sum == 0) {
			return 1;
		}

		if (n == 0) {
			return 0;
		}

		if (arr[n - 1] <= sum) {
			return findCnt(arr, sum - arr[n - 1], n - 1) + findCnt(arr, sum, n - 1);
		} else if (arr[n - 1] > sum) {
			return findCnt(arr, sum, n - 1);
		}
		return 0;
	}
}
