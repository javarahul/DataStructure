package array.string;

import java.util.HashMap;

public class IsomrophicString1 {

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

		HashMap<Character, Character> map1 = new HashMap<>();
		HashMap<Character, Character> map2 = new HashMap<>();

		for (int i = 0; i < s1.length(); i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);

			if (map1.containsKey(c1)) {
				if (c2 != map1.get(c1)) {
					return false;
				}
			} else {
				if (map2.containsKey(c2)) {
					return false;
				}
				map1.put(c1, c2);
				map2.put(c2, c1);
			}
		}
		return true;
	}
}
