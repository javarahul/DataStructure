package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIterativeTraversal2 {

	public static void main(String[] args) {
		Node root = initializeTree();

		List<Integer> result = inOrderIterativeTraversal(root);

		System.out.println("List after In order traversal:-> " + result);
	}

	private static List<Integer> inOrderIterativeTraversal(Node root) {
		List<Integer> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node top = stack.peek();

			if (top.left != null) {
				stack.push(top.left);
				top.left = null;
			} else {
				result.add(top.val);
				stack.pop();
				if (top.right != null) {
					stack.push(top.right);
				}
			}
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
