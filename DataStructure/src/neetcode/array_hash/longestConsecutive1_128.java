package neetcode.array_hash;

public class longestConsecutive1_128 {

	public static void main(String[] args) {
		int nums[] = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };// { 12, 34, 7, 4, 2, 6, 8, 1, 9 };// { 100, 4, 200, 1, 3, 2 };
		System.out.println(longestConsecutive(nums));
	}

	private static int longestConsecutive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(" " + nums[i]);
		}
		bubbleSort(nums);
		System.out.println();
		for (int i = 0; i < nums.length; i++) {
			System.out.print(" " + nums[i]);
		}
		int size = nums.length;
		int longest_sequence = 0;
		int count = 1; // used to keep track of length of sequence
		for (int i = 0; i < size; i++) {
			if (i < size - 1 && nums[i + 1] - nums[i] == 1)
				count++;
			else if (i < size - 1 && nums[i + 1] == nums[i]) {
				// skip this step as a duplicate is found
			} else {
				if (longest_sequence < count) {
					longest_sequence = count;
				}
				count = 1;
			}
		}
		return longest_sequence;
	}

	private static void bubbleSort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}
}
