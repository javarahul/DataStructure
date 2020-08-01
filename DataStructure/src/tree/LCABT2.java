package tree;

import java.util.Scanner;

public class LCABT2 {
	private static boolean v1;
	private static boolean v2;

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
		v1 = false;
		v2 = false;

		Node lca = getLCABT(root, n1, n2);

		if (v1 && v2) {
			return lca;
		}
		return null;
	}

	private static Node getLCABT(Node root, int n1, int n2) {
		if (root == null) {
			return null;
		}

		Node temp = null;

		if (root.val == n1) {
			v1 = true;
			temp = root;
		}

		if (root.val == n2) {
			v2 = true;
			temp = root;
		}

		Node leftLCA = getLCABT(root.left, n1, n2);
		Node rightLCA = getLCABT(root.right, n1, n2);

		if (temp != null) {
			return temp;
		}

		if (leftLCA != null && rightLCA != null) {
			return root;
		}

		if (leftLCA != null) {
			return leftLCA;
		} else {
			return rightLCA;
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
