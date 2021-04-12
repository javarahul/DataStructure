package growkking.slidingwindowpattern;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

	public static void main(String[] args) {
		System.out.println(CharacterReplacement.findLength("aabccbb", 2));
		System.out.println(CharacterReplacement.findLength("abbcb", 1));
		System.out.println(CharacterReplacement.findLength("abccde", 1));
	}

	private static int findLength(String str, int k) {
		int maxLen = Integer.MIN_VALUE;
		int winStart = 0;
		int maxRepeatLetterCount = 0;

		Map<Character, Integer> letterFrequencyMap = new HashMap<>();

		for (int winEnd = 0; winEnd < str.length(); winEnd++) {
			char rightChar = str.charAt(winEnd);
			letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
			maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

			if (winEnd - winStart + 1 - maxRepeatLetterCount > k) {
				char leftChar = str.charAt(winStart);
				letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
				winStart++;
			}
			maxLen = Math.max(maxLen, winEnd - winStart + 1);
		}
		return maxLen;
	}
}
