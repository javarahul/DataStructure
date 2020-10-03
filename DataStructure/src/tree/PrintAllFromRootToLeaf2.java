package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrintAllFromRootToLeaf2 {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Inorder Traversal of the BST:-> ");
		Node tempRoot = root;
		printInorder(tempRoot);
		System.out.println();

		List<String> finalResult = printRootToLeaf(root);

		System.out.println(finalResult);
	}

	private static List<String> printRootToLeaf(Node root) {
		ArrayList<String> finalResult = new ArrayList<>();
		if (root == null) {
			return finalResult;
		}

		ArrayList<String> curr = new ArrayList<>();
		ArrayList<ArrayList<String>> results = new ArrayList<>();

		dfs(root, results, curr);

		for (ArrayList<String> al : results) {
			StringBuilder sb = new StringBuilder();
			sb.append(al.get(0));
			for (int i = 1; i < al.size(); i++) {
				sb.append("->" + al.get(i));
			}
			finalResult.add(sb.toString());
		}
		return finalResult;
	}

	private static void dfs(Node root, ArrayList<ArrayList<String>> results, ArrayList<String> curr) {
		curr.add(String.valueOf(root.val));
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			results.add(curr);
			return;
		}

		if (root.left != null) {
			ArrayList<String> temp = new ArrayList<>(curr);
			dfs(root.left, results, temp);
		}

		if (root.right != null) {
			ArrayList<String> temp = new ArrayList<>(curr);
			dfs(root.right, results, temp);
		}
	}

	private static void printPath(int[] path, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
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
