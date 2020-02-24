package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderBottomUpTraversal {

	public static void main(String[] args) {
		Node root = initializeTree();

		List<ArrayList<Integer>> result = levelOrderBottom(root);

		System.out.println("List after Level order traversal:-> " + result);
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

	public static List<ArrayList<Integer>> levelOrderBottom(Node root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (root == null) {
			return result;
		}

		LinkedList<Node> current = new LinkedList<Node>();
		LinkedList<Node> next = new LinkedList<Node>();
		current.offer(root);

		ArrayList<Integer> numberList = new ArrayList<Integer>();

		// need to track when each level starts
		while (!current.isEmpty()) {
			Node head = current.poll();

			numberList.add(head.val);

			if (head.left != null) {
				next.offer(head.left);
			}
			if (head.right != null) {
				next.offer(head.right);
			}

			if (current.isEmpty()) {
				current = next;
				next = new LinkedList<Node>();
				result.add(numberList);
				numberList = new ArrayList<Integer>();
			}
		}

		// return Collections.reverse(result);
		ArrayList<ArrayList<Integer>> reversedResult = new ArrayList<ArrayList<Integer>>();
		for (int i = result.size() - 1; i >= 0; i--) {
			reversedResult.add(result.get(i));
		}

		return reversedResult;
	}
}
