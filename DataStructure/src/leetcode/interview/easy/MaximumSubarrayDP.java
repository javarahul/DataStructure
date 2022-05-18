package leatcode.interview.easy;

public class MaximumSubarrayDP {

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int ans = maxSubArray(nums);

		System.out.println("Max Sub Array:-> " + ans);
	}

	public static int maxSubArray(int[] nums) {
		int max = nums[0];
		int sum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(nums[i], sum + nums[i]);
			max = Math.max(max, sum);
		}

		return max;
	}
}
