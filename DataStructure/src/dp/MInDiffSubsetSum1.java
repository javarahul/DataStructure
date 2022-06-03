package dp;

public class MInDiffSubsetSum1 {
	static boolean dp[][];

	public static void main(String[] args) {
		int arr[] = { -36,36 };
		int n = arr.length;

		int minDiff = findMinDiff(arr, n);
		System.out.println("Minimum difference is:-> " + minDiff);
	}

	private static int findMinDiff(int[] arr, int n) {
		int totalSum = 0;
		for (int i = 0; i < n; i++) {
			totalSum += arr[i];
		}

		dp = new boolean[n + 1][totalSum + 1];

		return findMinDiffRec(arr,n, totalSum);
	}

	private static int findMinDiffRec(int[] arr, int n, int totalSum) {
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < totalSum + 1; j++) {
				if (i == 0) {
					dp[i][j] = false;
				}
				if (j == 0) {
					dp[i][j] = true;
				}
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < totalSum + 1; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
				} else if (arr[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		int minDiff = Integer.MAX_VALUE;
		for (int j = totalSum / 2; j >= 0; j--) {
			if (dp[arr.length][j] == true) {
				minDiff = totalSum - 2 * j;
				break;
			}
		}

		return minDiff;
	}
}
