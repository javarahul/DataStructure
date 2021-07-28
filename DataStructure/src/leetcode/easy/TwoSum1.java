package leetcode.easy;

import java.util.Arrays;

public class TwoSum1 {

	public static void main(String[] args) {
		int A[] = { 1, 4, 45, 6, 10, -8 };
		int n = 16;

		int result[] = new int[2];

		result = twosum(A, n);

		System.out.println(result[0] + "," + result[1]);
	}

	private static int[] twosum(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;

		Arrays.sort(nums);

		while (l < r) {
			int tempSum = nums[l] + nums[r];
			if (tempSum == target) {
				return new int[] { l, r };
			} else if (tempSum < target) {
				l++;
			} else {
				r--;
			}
		}
		return null;
	}
}
