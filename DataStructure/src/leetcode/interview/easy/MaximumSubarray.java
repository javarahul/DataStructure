package leatcode.interview.easy;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int ans = maxSubArray(nums);

		System.out.println("Max Sub Array:-> " + ans);
	}

	public static int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int maxEnd = 0;
		for (int i = 0; i < nums.length; i++) {
			maxEnd = maxEnd + nums[i];
			if (max < maxEnd) {
				max = maxEnd;
			}

			if (maxEnd < 0) {
				maxEnd = 0;
			}
		}
		return max;
	}
}
