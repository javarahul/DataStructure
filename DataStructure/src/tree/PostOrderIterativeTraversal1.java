package tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderIterativeTraversal1 {

	public static void main(String[] args) {
		Node root = initializeTree();

		ArrayList<Integer> result = postOrderIterativeTraversal(root);

		System.out.println("List after post order traversal:-> " + result);
	}

	private static ArrayList<Integer> postOrderIterativeTraversal(Node root) {
		ArrayList<Integer> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		Stack<Node> stack = new Stack<>();
		stack.push(root);

		Node prev = null;

		while (!stack.isEmpty()) {
			Node curr = stack.peek();

			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					stack.push(curr.left);
				} else if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					result.add(curr.val);
				}
			} else if (curr.left == prev) {
				if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					result.add(curr.val);
				}
			} else if (curr.right == prev) {
				stack.pop();
				result.add(curr.val);
			}
			prev = curr;
		}
		return result;
	}

	private static Node initializeTree() {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.left.left = new Node(70);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.left.left.right = new Node(80);

		return root;
	}
}
