package array.string;

import java.util.HashMap;
import java.util.HashSet;

public class IsomrophicString2 {

	public static void main(String[] args) {
		boolean res = isIsomorphic("aab", "xxy");
		System.out.println(res);

		res = isIsomorphic("aab", "xyz");
		System.out.println(res);
	}

	private static boolean isIsomorphic(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		HashMap<Character, Character> map = new HashMap<>();

		for (int i = 0; i < s1.length(); i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);

			if (map.containsKey(c1)) {
				if (c2 != map.get(c1)) {
					return false;
				}
			} else {
				map.put(c1, c2);
			}
		}

		HashSet<Character> set = new HashSet<>(map.values());

		if (set.size() == map.values().size()) {
			return true;
		}
		return false;
	}
}
