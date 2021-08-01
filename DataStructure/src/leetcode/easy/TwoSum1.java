package leetcode.easy;

import java.util.Arrays;

public class TwoSum1 {

	public static void main(String[] args) {
		int A[] = { 1, 4, 45, 6, 10, -8 };
		int n = 16;

		boolean result = twosum(A, n);

		if (result) {
			System.out.println("Pairs are present");
		}else {
			System.out.println("Pairs are not present");
		}
	}

	private static boolean twosum(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;

		Arrays.sort(nums);

		while (l < r) {
			int tempSum = nums[l] + nums[r];
			if (tempSum == target) {
				return true;
			} else if (tempSum < target) {
				l++;
			} else {
				r--;
			}
		}
		return false;
	}
}
