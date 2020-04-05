package tree;

import java.util.LinkedList;
import java.util.Scanner;

public class PathSumBST2 {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Inorder Traversal of the BST:-> ");
		Node tempRoot = root;
		printInorder(tempRoot);
		System.out.println();

		System.out.println("Enetr the sum which for which we need Path:-> ");
		Scanner scanner = new Scanner(System.in);
		int sum = scanner.nextInt();

		boolean hasPathSum = hasPathSum(root, sum);

		System.out.println("path is avialble for the given sum:-> " + hasPathSum);
	}

	private static boolean hasPathSum(Node root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.val == sum && (root.left == null && root.right == null)) {
			return true;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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

	private static void printInorder(Node root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}
}
