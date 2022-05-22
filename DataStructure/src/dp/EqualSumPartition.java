package dp;

public class EqualSumPartition {
	private static int dp[][];

	public static void main(String[] args) {
		int arr[] = { 3, 1, 5, 9, 12 };
		int n = arr.length;

		if (findPartition(arr, n) == 1) {
			System.out.println("Can be divided into two " + "subsets of equal sum");
		} else {
			System.out.println("Can not be divided into " + "two subsets of equal sum");
		}
	}

	private static int findPartition(int[] arr, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}

		if (sum % 2 != 0) {
			return 0;
		} else {
			dp = new int[n + 1][sum / 2 + 1];
			for (int i = 0; i < n + 1; i++) {
				for (int j = 0; j < sum / 2 + 1; j++) {
					dp[i][j] = -1;
				}
			}
			return subsetSum(arr, n, sum / 2);
		}
	}

	private static int subsetSum(int[] arr, int n, int sum) {
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
			dp[n][sum] = subsetSum(arr, n - 1, sum - arr[n - 1]) | subsetSum(arr, n - 1, sum);
		} else if (arr[n - 1] > sum) {
			dp[n][sum] = subsetSum(arr, n - 1, sum);
		}
		return dp[n][sum];
	}

}
