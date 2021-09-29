package leetcode.easy;

import java.util.HashMap;
import java.util.Stack;

public class ValidParantheses {

	public static void main(String[] args) {
		String expr = "([{}])";

		if (isValid(expr)) {
			System.out.println("Balanced ");
		} else {
			System.out.println("Not Balanced ");
		}
	}

	private static boolean isValid(String expr) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < expr.length(); i++) {
			char curr = expr.charAt(i);
			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.empty();
	}
}
