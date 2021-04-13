package growkking.slidingwindowpattern;

public class ReplacingOnes {

	public static void main(String[] args) {
		System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
		System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
	}

	private static int findLength(int[] arr, int k) {
		int maxLen = Integer.MIN_VALUE;
		int winStart = 0;
		int maxOnesCount = 0;

		for (int winEnd = 0; winEnd < arr.length; winEnd++) {
			if (arr[winEnd] == 1) {
				maxOnesCount++;
			}
			if (winEnd - winStart + 1 - maxOnesCount > k) {
				if (arr[winStart] == 1) {
					maxOnesCount--;
				}
				winStart++;
			}
			maxLen = Math.max(maxLen, winEnd - winStart + 1);
		}
		return maxLen;
	}
}
