package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes3 {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Inorder Traversal of the BST:-> ");
		Node tempRoot = root;
		printInorder(tempRoot);
		System.out.println();

		int total = getCountCompleteTreeNodes(root);

		System.out.println("Total Available Nodes in tree:-> " + total);
	}

	private static int getCountCompleteTreeNodes(Node node) {
		if (node == null) {
			return 0;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);

		int count = 0;
		while (!queue.isEmpty()) {
			Node head = queue.poll();

			if (head.left != null && head.right != null) {
				count++;
			}

			if (head.left != null) {
				queue.add(head.left);
			}

			if (head.right != null) {
				queue.add(head.right);
			}
		}
		return count;
	}

	private static Node initializeTree() {
		Node root = new Node(6);
		root.left = new Node(3);
		root.right = new Node(5);
		root.right.right = new Node(4);
		root.left.left = new Node(2);
		root.left.right = new Node(5);
		root.left.right.right = new Node(4);
		root.left.right.left = new Node(7);

		return root;
	}

	private static void printInorder(Node root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}
}
