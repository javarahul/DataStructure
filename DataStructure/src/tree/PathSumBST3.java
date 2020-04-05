package tree;

import java.util.LinkedList;
import java.util.Scanner;

public class PathSumBST3 {

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
			return (sum == 0);
		}

		boolean ans = false;

		int subTotal = sum - root.val;

		if (subTotal == 0 && root.left == null && root.right == null) {
			return true;
		}

		if (root.left != null) {
			ans = ans || hasPathSum(root.left, subTotal);
		}
		if (root.right != null) {
			ans = ans || hasPathSum(root.right, subTotal);
		}
		return ans;
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
