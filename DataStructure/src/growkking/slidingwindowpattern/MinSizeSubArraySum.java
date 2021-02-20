package growkking.slidingwindowpattern;

public class MinSizeSubArraySum {
	public static void main(String[] args) {
		int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
		System.out.println("Smallest subarray length: " + result);
		result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
		System.out.println("Smallest subarray length: " + result);
		result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
		System.out.println("Smallest subarray length: " + result);
	}

	private static int findMinSubArray(int s, int[] array) {
		int winSum = 0;
		int minLen = Integer.MAX_VALUE;
		int winStart = 0;

		for (int winEnd = 0; winEnd < array.length; winEnd++) {
			winSum += array[winEnd];

			while (winSum >= s) {
				minLen = Math.min(minLen, winEnd - winStart + 1);
				winSum -= array[winStart];
				winStart++;
			}
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
}
