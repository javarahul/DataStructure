package tree;

import java.util.Scanner;

public class ClosestBSTValue1 {

	private static int goal;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Inorder Traversal of the BST:-> ");
		Node tempRoot = root;
		printInorder(tempRoot);
		System.out.println();

		System.out.println("Enter target val:-> ");
		int target = new Scanner(System.in).nextInt();

		int total = getClosestBSTValue(root, target);

		System.out.println("Total Available Nodes in tree:-> " + total);
	}

	private static int getClosestBSTValue(Node root, int target) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}

		if (Math.abs(root.val - target) < min) {
			min = Math.abs(root.val - target);
			goal = root.val;
		}

		if (target < root.val) {
			getClosestBSTValue(root.left, target);
		} else {
			getClosestBSTValue(root.right, target);
		}
		return goal;
	}

	private static Node initializeTree() {
		Node root = new Node(9);
		root.left = new Node(4);
		root.right = new Node(17);
		root.left.left = new Node(3);
		root.left.right = new Node(6);
		root.left.right.left = new Node(5);
		root.left.right.right = new Node(7);
		root.right.right = new Node(22);
		root.right.right.left = new Node(20);

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
