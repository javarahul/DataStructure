package array;

import java.util.ArrayList;

public class SubarraySum {
	public static void main(String[] args) {
		ArrayList<Integer> result = SubarraySum.findSubArraySum(12, new int[] { 1, 2, 3, 7, 5 });
		System.out.println("Contiguous SubArray Sum indexes: " + result);
		result = SubarraySum.findSubArraySum(15, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		System.out.println("Contiguous SubArray Sum indexes: " + result);
		result = SubarraySum.findSubArraySum(33, new int[] { 1, 4, 20, 3, 10, 5 });
		System.out.println("Contiguous SubArray Sum indexes: " + result);
		result = SubarraySum.findSubArraySum(7, new int[] { 1, 4, 0, 0, 3, 10, 5 });
		System.out.println("Contiguous SubArray Sum indexes: " + result);
		result = SubarraySum.findSubArraySum(0, new int[] { 1, 4 });
		System.out.println("Contiguous SubArray Sum indexes: " + result);
	}

	private static ArrayList<Integer> findSubArraySum(int s, int[] array) {
		int winStart = 0;
		ArrayList<Integer> result = new ArrayList<>(2);
		int winSum = 0;
		boolean isFound = false;

		for (int winEnd = 0; winEnd < array.length; winEnd++) {
			winSum += array[winEnd];
			result.clear();
			result.add(0, winStart + 1);
			if (winSum > 0 && s == 0) {
				result.clear();
				result.add(0, -1);
				break;
			}
			if (winSum == s) {
				result.add(1, winEnd + 1);
				isFound = true;
				break;
			} else if (winSum > s) {
				while (winSum > s) {
					winSum -= array[winStart];
					winStart++;
					result.clear();
					result.add(0, winStart + 1);
					if (winSum == s) {
						result.add(1, winEnd + 1);
						isFound = true;
						break;
					}
				}
				if (isFound) {
					break;
				}
			}
		}
		if (!isFound){
			result.clear();
			result.add(0, -1);
		}
		return result;
	}
}
