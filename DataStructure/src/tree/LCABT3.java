package tree;

import java.util.Scanner;

public class LCABT3 {
	public static void main(String[] args) {

		System.out.println("Elements in PreOrder:-> ");
		Node root = initializeTree();
		printPreOrder(root);

		System.out.println();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First item: ");
		int n1 = sc.nextInt();

		System.out.println("Enter Second item: ");
		int n2 = sc.nextInt();

		Node lca = getLCA(root, n1, n2);
		if (lca != null) {
			System.out.println("LCA of " + n1 + " and " + +n2 + " :" + lca.val);
		} else {
			System.out.println("LCA of " + n1 + " and " + +n2 + " :" + null);
		}
	}

	private static Node getLCA(Node root, int n1, int n2) {
		if (root == null) {
			return null;
		}

		if (root.val == n1 || root.val == n2) {
			return root;
		}

		Node left = getLCA(root.left, n1, n2);
		Node right = getLCA(root.right, n1, n2);

		if (left != null && right != null) {
			return root;
		} else if (left == null && right == null) {
			return null;
		} else {
			if (left == null) {
				return right;
			} else {
				return left;
			}
		}
	}

	private static void printPreOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}

	private static void printInOrder(Node root) {
		if (root == null) {
			return;
		}
		printPreOrder(root.left);
		System.out.print(root.val + " ");
		printPreOrder(root.right);
	}

	private static Node initializeTree() {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		return root;
	}
}
