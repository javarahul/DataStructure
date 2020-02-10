package tree;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderIterativeTraversal1 {

	public static void main(String[] args) {
		Node root = initializeTree();

		ArrayList<Integer> result = preOrderIterativeTraversal(root);

		System.out.println("Result of pre order traversal:-> " + result);
	}

	private static ArrayList<Integer> preOrderIterativeTraversal(Node root) {
		ArrayList<Integer> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			result.add(temp.val);

			if (temp.right != null) {
				stack.push(temp.right);
			}

			if (temp.left != null) {
				stack.push(temp.left);
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
