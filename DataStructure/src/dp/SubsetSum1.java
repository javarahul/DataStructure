package dp;

public class SubsetSum1 {
	private static boolean[][] dp;

	public static void main(String[] args) {
		int n = 5;
        int set[] = { 1, 5, 3, 7, 4 };
        int sum = 16;

		dp = new boolean[n + 1][sum + 1];

		if (isSubsetSum(set, n, sum)) {
			System.out.println("Found a subset" + " with given sum");
		} else {
			System.out.println("No subset with" + " given sum");
		}
	}

	private static boolean isSubsetSum(int[] set, int n, int sum) {
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0) {
					dp[i][j] = false;
				}
				if (j == 0) {
					dp[i][j] = true;
				}
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (set[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - set[i - 1]] || dp[i - 1][j];
				} else if (set[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][sum];
	}

}
