package binarysearch;

public class FindMinInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = { 3, 4, 5, 1, 2 };

		int minElement = findMin(nums);

		System.out.println("Min element in given array is:-> " + minElement);
	}

	private static int findMin(int[] nums) {
		int start = 0;
		int len = nums.length;
		int end = nums.length - 1;
		int min = nums[start];

		while (start <= end) {
			if (nums[start] <= nums[end]) {
				return nums[start];
			}
			int mid = start + (end - start) / 2;
			int next = (mid + 1) % len;
			int prev = (mid + len - 1) % len;

			if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
				return nums[mid];
			} else if (nums[mid] >= nums[start]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return min;
	}
}
