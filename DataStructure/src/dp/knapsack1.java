package dp;

public class knapsack1 {

	public static void main(String[] args) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}

	private static int knapSack(int w, int[] wt, int[] val, int n) {
		int dp[][] = new int[n + 1][w + 1];
		// Initialize first row and column based on base condition in case of knapsack
		// recursive solution
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < w + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}

		//Covert below lines of code directly from Choice diagram of recursive methodology
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < w + 1; j++) {
				if (wt[i - 1] <= j) {
					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
				} else if (wt[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][w];
	}
}
