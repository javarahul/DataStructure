package dp;

public class CountOfSubsetSumOfAGivenSum1 {

	private static int[][] dp;

	public static void main(String[] args) {
		int arr[] = { 3, 3, 3, 3 };
		int n = arr.length;
		int sum = 6;
		dp = new int[n + 1][sum + 1];

		System.out.println(findCnt(arr, sum, n));
	}

	private static int findCnt(int[] arr, int sum, int n) {
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0) {
					dp[i][j] = 0;
				}

				if (j == 0) {
					dp[i][j] = 1;
				}
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
				} else if (arr[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][sum];
	}
}
