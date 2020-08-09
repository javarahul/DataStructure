package tree;

import java.util.Stack;

public class SynchronizationBT2 {

	public static void main(String[] args) {
		String preOrderStr = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		System.out.println("Elements in PreOrder:-> " + preOrderStr);
		System.out.println();

		boolean isSynchronized = getValidSynchronization(preOrderStr);

		System.out.println("Tree is synchronized: " + isSynchronized);
	}

	private static boolean getValidSynchronization(String preOrderStr) {
		String[] arr = preOrderStr.split(",");

		Stack<String> stack = new Stack<>();

		for (String str : arr) {
			if (stack.isEmpty() || !str.equals("#")) {
				stack.push(str);
			} else {
				while (!stack.isEmpty() && stack.peek().equals("#")) {
					stack.pop();
					if (stack.isEmpty()) {
						return false;
					} else {
						stack.pop();
					}
				}
				stack.push("#");
			}
		}
		return stack.size() == 1 && stack.peek().equals("#");
	}
}
