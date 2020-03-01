package tree;

import java.util.LinkedList;

public class InvertTreeIterative {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Given Tree: ");
		printInorder(root);
		System.out.println();

		root = invertTree(root);

		System.out.println("Tree after inversion: ");
		printInorder(root);
	}

	private static Node invertTree(Node root) {
		if (root == null) {
			return root;
		}

		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node p = queue.poll();

			if (p.left != null) {
				queue.add(p.left);
			}
			if (p.right != null) {
				queue.add(p.right);
			}

			Node temp = p.left;
			p.left = p.right;
			p.right = temp;
		}
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
