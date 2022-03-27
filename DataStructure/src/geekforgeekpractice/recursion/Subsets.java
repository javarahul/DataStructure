package geeksforgeeks.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };

		List<List<Integer>> result = solution(nums, 0);
		System.out.println(result);
	}

	private static List<List<Integer>> solution(int[] nums, int index) {
		ArrayList<Integer> currSum = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		subsets(nums, index, currSum, result);
		return result;
	}

	private static void subsets(int[] nums, int index, ArrayList<Integer> currSub, List<List<Integer>> result) {
		if (index == nums.length) {
			result.add(currSub);
			return;
		}
		subsets(nums, index + 1, new ArrayList<>(currSub), result);
		currSub.add(nums[index]);
		subsets(nums, index + 1, new ArrayList<>(currSub), result);
		return;
	}
}
