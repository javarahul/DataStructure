package leetcode.easy;

import java.util.HashMap;

public class TwoSum2 {

	public static void main(String[] args) {
		int A[] = { 1, 4, 45, 6, 10, -8 };
		int n = 16;

		int result[] = new int[2];

		result = twosum(A, n);

		System.out.println(result[0] + "," + result[1]);
	}

	private static int[] twosum(int nums[], int target) {
		if (nums == null || nums.length < 2) {
			return new int[] { 0, 0 };
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return new int[] {map.get(nums[i]),i};
			}else {
				map.put(target-nums[i], i);
			}
		}
		return new int[] { 0, 0 };
	}
}
