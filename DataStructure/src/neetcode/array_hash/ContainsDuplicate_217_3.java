package neetcode.array_hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217_3 {

	public static void main(String[] args) {
//		int nums[] = { 1, 2, 3, 1 };
//		int nums[] = {1,2,3,4};
		int nums[] = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
		boolean isDuplicate = containsDuplicate(nums);
		System.out.println("Array having duplicate item:- " + isDuplicate);
	}

	public static boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				return true;
			}
		}
		return false;
	}
}
