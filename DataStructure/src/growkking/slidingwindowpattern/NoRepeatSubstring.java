package growkking.slidingwindowpattern;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {
	public static void main(String[] args) {
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
	}

	private static int findLength(String str) {
		int maxLen = 0;
		int winStart = 0;

		Map<Character, Integer> charIndexMap = new HashMap<>();

		for (int winEnd = 0; winEnd < str.length(); winEnd++) {
			char rightChar = str.charAt(winEnd);

			if (charIndexMap.containsKey(rightChar)) {
				winStart = Math.max(winStart, charIndexMap.get(rightChar) + 1);
			}
			charIndexMap.put(rightChar, winEnd);
			maxLen = Math.max(maxLen, winEnd - winStart + 1);
		}
		return maxLen;
	}
}
