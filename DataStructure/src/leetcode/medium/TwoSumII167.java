package grokking.slidingwindowpattern.twopointerspattern;

public class TwoSumII167 {

	public static void main(String[] args) {
		int arr[] = { -1,0 }, x = -1;
		int n = arr.length;
		int result[] = printClosest(arr, x);
		System.out.println(result[0] + ", " + result[1]);
	}

	private static int[] printClosest(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			int currSum = arr[left] + arr[right];
			if (currSum == target) {
				System.out.println(left + ", " + right);
				return new int[] { left + 1, right + 1 };
			}
			if (currSum < target) {
				left++;
			} else {
				right--;
			}
		}
		return new int[] { -1, -1 };
	}
}
