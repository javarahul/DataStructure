package leetcode.easy;

public class TwoSumPairs {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 7, -1, 5 };
		int sum = 6;
		getPairsCount(arr, sum);
	}

	private static void getPairsCount(int[] nums, int sum) {
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == sum) {
					count++;
				}
			}
		}

		System.out.println("Count of Pairs is:-> " + count);
	}
}
