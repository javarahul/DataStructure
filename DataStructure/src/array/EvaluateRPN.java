package array;

import java.util.Stack;

public class EvaluateRPN {

	public static void main(String[] args) {
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };
		System.out.println(evalRPN(tokens));
	}

	private static int evalRPN(String[] tokens) {
		int returnVal = 0;
		String operator = "+-*/";
		Stack<String> mStack = new Stack<>();

		for (String t : tokens) {
			if (!operator.contains(t)) {
				mStack.push(t);
			} else {
				int a = Integer.valueOf(mStack.pop());
				int b = Integer.valueOf(mStack.pop());
				int index = operator.indexOf(t);
				
				switch (index) {
				case 0:
					mStack.push(String.valueOf(a + b));
					break;
				case 1:
					mStack.push(String.valueOf(b - a));
					break;
				case 2:
					mStack.push(String.valueOf(a * b));
					break;
				case 3:
					mStack.push(String.valueOf(b / a));
					break;
				default:
					break;
				}
			}
		}
		returnVal = Integer.valueOf(mStack.pop());
		return returnVal;
	}
}
