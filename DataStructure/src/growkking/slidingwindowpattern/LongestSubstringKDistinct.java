package growkking.slidingwindowpattern;

import java.util.HashMap;

public class LongestSubstringKDistinct {

	public static void main(String[] args) {
		System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
		System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
		System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
	}

	private static int findLength(String str, int k) {
		int winStart = 0;
		int maxLen = Integer.MIN_VALUE;

		HashMap<Character, Integer> charFrequencyMap = new HashMap<>();

		for (int winEnd = 0; winEnd < str.length(); winEnd++) {
			char rightChar = str.charAt(winEnd);

			charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);

			while (charFrequencyMap.size() > k) {
				char leftChar = str.charAt(winStart);
				charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
				if (charFrequencyMap.get(leftChar) == 0) {
					charFrequencyMap.remove(leftChar);
				}
				winStart++;
			}
			maxLen = Math.max(maxLen, winEnd - winStart + 1);
		}
		return maxLen;
	}
}
