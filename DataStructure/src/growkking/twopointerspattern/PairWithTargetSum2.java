package growkking.twopointerspattern;

import java.util.HashMap;

public class PairWithTargetSum2 {

	public static void main(String[] args) {
		int[] result = PairWithTargetSum2.search(new int[] { 1, 2, 3, 4, 6 }, 6);
		System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
		result = PairWithTargetSum2.search(new int[] { 2, 5, 9, 11 }, 11);
		System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
	}

	private static int[] search(int[] arr, int targetSum) {
		HashMap<Integer, Integer> nums = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (nums.containsKey(targetSum - arr[i])) {
				return new int[] { nums.get(targetSum - arr[i]), i };
			} else {
				nums.put(arr[i], i);
			}
		}
		return new int[] { -1, -1 };
	}

}
