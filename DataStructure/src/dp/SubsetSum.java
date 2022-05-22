package dp;

public class SubsetSum {

	private static int[][] dp;

	public static void main(String[] args) {
		int n = 5;
        int set[] = { 1, 5, 3, 7, 4 };
        int sum = 17;

		dp = new int[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				dp[i][j] = -1;
			}
		}

		int result = isSubsetSum(set, n, sum);

		if (result == 1) {
			System.out.println("Found a subset" + " with given sum");
		} else {
			System.out.println("No subset with" + " given sum");
		}
	}

	private static int isSubsetSum(int[] set, int n, int sum) {
		if (sum == 0) {
			return 1;
		}
		if (n == 0) {
			return 0;
		}

		if (dp[n][sum] != -1) {
			return dp[n][sum];
		}

		if (set[n - 1] <= sum) {
			dp[n][sum] = isSubsetSum(set, n - 1, sum - set[n - 1]) | isSubsetSum(set, n - 1, sum);
		} else if (set[n - 1] > sum) {
			dp[n][sum] = isSubsetSum(set, n - 1, sum);
		}
		return dp[n][sum];
	}
}
