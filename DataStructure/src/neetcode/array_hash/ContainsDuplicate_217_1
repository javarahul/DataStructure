package neetcode.array_hash;

public class ContainsDuplicate_217_1 {

	public static void main(String[] args) {
//		int nums[] = { 1, 2, 3, 1 };
//		int nums[] = {1,2,3,4};
		int nums[] = {1,1,1,3,3,4,3,2,4,2};
		boolean isDuplicate = containsDuplicate(nums);
		System.out.println("Array having duplicate item:- " + isDuplicate);
	}

	public static boolean containsDuplicate(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}
}
