package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParantheses2 {

	public static void main(String[] args) {
		String expr = "([{}])";

		if (isValid(expr)) {
			System.out.println("Balanced ");
		} else {
			System.out.println("Not Balanced ");
		}
	}

	private static boolean isValid(String expr) {
		Deque<Character> stack = new ArrayDeque<Character>();

		for (int i = 0; i < expr.length(); i++) {
			char curr = expr.charAt(i);

			if (curr == '(' || curr == '[' || curr == '{') {
				stack.push(curr);
				continue;
			}

			if (stack.isEmpty()) {
				return false;
			}
			char tempCurr = stack.pop();
			switch (curr) {
			case ')':
				if (tempCurr == '{' || tempCurr == '[')
					return false;
				break;

			case '}':
				if (tempCurr == '(' || tempCurr == '[')
					return false;
				break;

			case ']':
				if (tempCurr == '(' || tempCurr == '{')
					return false;
				break;
			}
		}
		return (stack.isEmpty());
	}
}
