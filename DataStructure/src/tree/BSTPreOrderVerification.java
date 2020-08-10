package tree;

import java.util.Stack;

public class BSTPreOrderVerification {

	public static void main(String[] args) {
		int[] pre1 = new int[] { 40, 30, 35, 80, 100 };
		int[] pre2 = new int[] { 40, 30, 35, 20, 80, 100 };
		System.out.print("Elements in PreOrder:-> ");

		display(pre2);

		System.out.println();

		boolean isValid = checkPreOrderVaidation(pre2);

		System.out.println("BST PreOrder Traversal is Valid: " + isValid);
	}

	private static void display(int[] pre1) {
		for (int i = 0; i < pre1.length; i++) {
			System.out.print(pre1[i] + " ");
		}
	}

	private static boolean checkPreOrderVaidation(int[] pre) {
		Stack<Integer> stack = new Stack<>();

		int root = Integer.MIN_VALUE;

		for (int i = 0; i < pre.length; i++) {
			if (pre[i] < root) {
				return false;
			}

			while (!stack.isEmpty() && stack.peek() < pre[i]) {
				root = stack.peek();
				stack.pop();
			}

			stack.push(pre[i]);
		}
		return true;
	}
}
