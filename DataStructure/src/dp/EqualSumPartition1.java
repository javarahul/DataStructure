package dp;

public class EqualSumPartition1 {
	private static boolean dp[][];

	public static void main(String[] args) {
		int arr[] = { 3, 1, 5, 9, 12 };
		int n = arr.length;

		if (findPartition(arr, n)) {
			System.out.println("Can be divided into two " + "subsets of equal sum");
		} else {
			System.out.println("Can not be divided into " + "two subsets of equal sum");
		}
	}

	private static boolean findPartition(int[] arr, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}

		if (sum % 2 != 0) {
			return false;
		} else {
			dp = new boolean[n + 1][sum / 2 + 1];
			return subsetSum(arr, n, sum / 2);
		}
	}

	private static boolean subsetSum(int[] arr, int n, int sum) {
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
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
				} else if (arr[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][sum];
	}
}
