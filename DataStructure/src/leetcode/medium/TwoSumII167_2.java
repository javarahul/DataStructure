package grokking.twopointerspattern;

import java.util.HashMap;

public class TwoSumII167_2 {

	public static void main(String[] args) {
		int arr[] = { 2,7,11,15 }, x = 9;
		int n = arr.length;
		int result[] = printClosest(arr, x);
		System.out.println(result[0] + ", " + result[1]);
	}

	private static int[] printClosest(int[] arr, int target) {
		HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (nums.containsKey(arr[i])) {
				return new int[] { nums.get(arr[i]) + 1, i + 1 };
			} else {
				nums.put(target - arr[i], i);
			}
		}
		return new int[] { -1, -1 };
	}
}
