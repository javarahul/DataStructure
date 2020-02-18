package tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class LevelOrderTraversal1 {

	public static void main(String[] args) {
		Node root = initializeTree();

		ArrayList<ArrayList<Integer>> result = levelOrderTraversal(root);

		System.out.println("List after In order traversal:-> " + result);

	}

	private static ArrayList<ArrayList<Integer>> levelOrderTraversal(Node root) {
		ArrayList<ArrayList<Integer>> row = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> nodeValues = new ArrayList<Integer>();
		if (root == null)
			return row;

		LinkedList<Node> current = new LinkedList<Node>();
		LinkedList<Node> next = new LinkedList<Node>();
		current.add(root);

		while (!current.isEmpty()) {
			Node node = current.remove();

			if (node.left != null) {
				next.add(node.left);
			}
			if (node.right != null) {
				next.add(node.right);
			}

			nodeValues.add(node.val);
			if (current.isEmpty()) {
				current = next;
				next = new LinkedList<Node>();
				row.add(nodeValues);
				nodeValues = new ArrayList<>();
			}
		}
		return row;
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
