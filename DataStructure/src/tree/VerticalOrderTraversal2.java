package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VerticalOrderTraversal2 {

	public static void main(String[] args) {
		Node root = initializeTree();

		List<List<Integer>> result = verticalOrder(root);

		System.out.println("List after Vertcal order traversal:-> " + result);
	}

	public static List<List<Integer>> verticalOrder(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		int[] mm = new int[2];
		getMinMax(root, mm, 0);

		int len = mm[1] - mm[0] + 1;

		for (int i = 0; i < len; i++) {
			result.add(new ArrayList<Integer>());
		}

		LinkedList<Node> q1 = new LinkedList<>();
		LinkedList<Integer> q2 = new LinkedList<>();

		q1.offer(root);
		q2.offer(0);

		while (!q1.isEmpty()) {
			Node h = q1.poll();
			int order = q2.poll();

			result.get(order - mm[0]).add(h.val);

			if (h.left != null) {
				q1.offer(h.left);
				q2.offer(order - 1);
			}
			if (h.right != null) {
				q1.offer(h.right);
				q2.offer(order + 1);
			}
		}

		return result;
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

	private static void getMinMax(Node node, int[] mm, int order) {
		if (node == null) {
			return;
		}

		mm[0] = Math.min(mm[0], order);
		mm[1] = Math.max(mm[1], order);

		getMinMax(node.left, mm, order - 1);
		getMinMax(node.right, mm, order + 1);
	}
}
