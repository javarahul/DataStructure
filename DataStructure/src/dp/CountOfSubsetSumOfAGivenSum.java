package dp;

public class CountOfSubsetSumOfAGivenSum {

	private static int[][] dp;

	public static void main(String[] args) {
		int arr[] = { 3, 3, 3, 3 };
		int n = arr.length;
		int sum = 6;
		dp = new int[n + 1][sum + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(findCnt(arr, sum, n));
	}

	private static int findCnt(int[] arr, int sum, int n) {
		if (sum == 0) {
			return 1;
		}

		if (n == 0) {
			return 0;
		}

		if (dp[n][sum] != -1) {
			return dp[n][sum];
		}

		if (arr[n - 1] <= sum) {
			dp[n][sum] = findCnt(arr, sum - arr[n - 1], n - 1) + findCnt(arr, sum, n - 1);
		} else if (arr[n - 1] > sum) {
			dp[n][sum] = findCnt(arr, sum, n - 1);
		}
		return dp[n][sum];
	}
}
