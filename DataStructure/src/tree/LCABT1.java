package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LCABT1 {
	private static List<Integer> path1 = new ArrayList<>();
	private static List<Integer> path2 = new ArrayList<>();

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Elements in PreOrder:-> ");
		printPreOrder(root);

		System.out.println();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First item: ");
		int n1 = sc.nextInt();

		System.out.println("Enter Second item: ");
		int n2 = sc.nextInt();

		int lca = getLCA(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + +n2 + " :" + lca);
	}

	private static int getLCA(Node root, int n1, int n2) {
		path1.clear();
		path2.clear();
		return getLCABT(root, n1, n2);
	}

	private static int getLCABT(Node root, int n1, int n2) {
		if (!findPath(root, n1, path1)) {
			if (path1.size() > 0) {
				System.out.println(n1 + " is present at path");
			} else {
				System.out.println(n1 + " is not present at path");
			}
			return -1;
		}
		if (!findPath(root, n2, path2)) {
			if (path2.size() > 0) {
				System.out.println(n2 + " is present at path");
			} else {
				System.out.println(n2 + " is not present at path");
			}
			return -1;
		}

		int i;

		for (i = 0; i < path1.size() && i < path2.size(); i++) {
			if (!path1.get(i).equals(path2.get(i))) {
				break;
			}
		}
		return path1.get(i - 1);
	}

	private static boolean findPath(Node root, int n, List<Integer> path) {
		if (root == null) {
			return false;
		}

		path.add(root.val);
		if (root.val == n) {
			return true;
		}

		if (root.left != null && findPath(root.left, n, path)) {
			return true;
		}

		if (root.right != null && findPath(root.right, n, path)) {
			return true;
		}

		path.remove(path.size() - 1);
		return false;
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
