package tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderIterativeTraversal2 {

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

		while (!stack.isEmpty()) {
			Node temp = stack.peek();

			if (temp.left == null && temp.right == null) {
				Node pop = stack.pop();
				result.add(pop.val);
			} else {
				if (temp.right != null) {
					stack.push(temp.right);
					temp.right = null;
				}

				if (temp.left != null) {
					stack.push(temp.left);
					temp.left = null;
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
