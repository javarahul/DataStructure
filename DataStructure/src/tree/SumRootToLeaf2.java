package tree;

import java.util.ArrayList;

public class SumRootToLeaf2 {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Inorder Traversal of the BST:-> ");
		Node tempRoot = root;
		printInorder(tempRoot);
		System.out.println();

		int total = getSumFromRootToLeaf(root);

		System.out.println("Sum from Root to leaf:-> " + total);
	}

	private static int getSumFromRootToLeaf(Node root) {
		int result = 0;
		if (root == null) {
			return result;
		}

		ArrayList<ArrayList<Node>> totalList = new ArrayList<ArrayList<Node>>();
		ArrayList<Node> list = new ArrayList<>();

		list.add(root);
		dfs(root, list, totalList);

		for (ArrayList<Node> list1 : totalList) {
			StringBuilder sb = new StringBuilder();
			for (Node node : list1) {
				sb.append(String.valueOf(node.val));
			}
			int curVal = Integer.parseInt(sb.toString());
			result = result + curVal;
		}
		return result;
	}

	private static void dfs(Node node, ArrayList<Node> list, ArrayList<ArrayList<Node>> totalList) {
		if (node.left == null && node.right == null) {
			ArrayList<Node> temp = new ArrayList<>();
			temp.addAll(list);
			totalList.add(temp);
		}

		if (node.left != null) {
			list.add(node.left);
			dfs(node.left, list, totalList);
			list.remove(list.size() - 1);
		}

		if (node.right != null) {
			list.add(node.right);
			dfs(node.right, list, totalList);
			list.remove(list.size() - 1);
		}
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
