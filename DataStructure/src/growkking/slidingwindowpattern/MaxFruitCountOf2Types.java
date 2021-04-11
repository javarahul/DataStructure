package growkking.slidingwindowpattern;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

	public static void main(String[] args) {
		System.out.println("Maximum number of fruits: "
				+ MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
		System.out.println("Maximum number of fruits: "
				+ MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
	}

	private static int findLength(char arr[]) {
		int winStart = 0;
		int maxLen = Integer.MIN_VALUE;

		Map<Character, Integer> fruitFequencyMap = new HashMap<>();

		for (int winEnd = 0; winEnd < arr.length; winEnd++) {
			char rightChar = arr[winEnd];
			fruitFequencyMap.put(rightChar, fruitFequencyMap.getOrDefault(rightChar, 0) + 1);
			if (fruitFequencyMap.size() > 2) {
				char leftChar = arr[winStart];
				fruitFequencyMap.put(leftChar, fruitFequencyMap.get(leftChar) - 1);

				if (fruitFequencyMap.get(leftChar) == 0) {
					fruitFequencyMap.remove(leftChar);
				}
				winStart++;
			}
			maxLen = Math.max(maxLen, winEnd - winStart + 1);
		}
		return maxLen;
	}
}
