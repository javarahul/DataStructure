package tree;

import java.util.LinkedList;
import java.util.Scanner;

public class PathSumBST1 {

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

		LinkedList<Node> nodes = new LinkedList<>();
		LinkedList<Integer> nodesSum = new LinkedList<>();

		nodes.add(root);
		nodesSum.add(root.val);

		while (!nodes.isEmpty()) {
			Node curr = nodes.pop();
			int currSum = nodesSum.pop();

			if (curr.left == null && curr.right == null && currSum == sum) {
				return true;
			}

			if (curr.left != null) {
				nodes.add(curr.left);
				nodesSum.add(currSum + curr.left.val);
			}
			if (curr.right != null) {
				nodes.add(curr.right);
				nodesSum.add(currSum + curr.right.val);
			}
		}
		return false;
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
