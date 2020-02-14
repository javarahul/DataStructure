package tree;

import java.util.ArrayList;
import java.util.Stack;

public class InorderIterativeTraversal1 {

	public static void main(String[] args) {
		Node root = initializeTree();

		ArrayList<Integer> result = inOrderIterativeTraversal(root);

		System.out.println("List after In order traversal:-> " + result);
	}

	private static ArrayList<Integer> inOrderIterativeTraversal(Node root) {
		ArrayList<Integer> result = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		Node ptr = root;
		while (ptr != null) {
			stack.push(ptr);
			ptr = ptr.left;
		}

		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			result.add(temp.val);
			temp = temp.right;

			while (temp != null) {
				stack.push(temp);
				temp = temp.left;
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
