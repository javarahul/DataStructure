package tree;

import java.util.ArrayList;
import java.util.List;

public class PrintLeafNodes1 {
	public static void main(String[] args) {
		PrintLeafNodes1 leafNodes = new PrintLeafNodes1();
		Node root = leafNodes.initializeTree();
		System.out.println("Tree in InOrder:-> ");
		leafNodes.inOrder(root);
		System.out.println();

		List<List<Integer>> leavesList = leafNodes.findLeaves(root);

		for (List<Integer> list : leavesList) {
			for (int items : list) {
				System.out.print(" " + items);
			}
			System.out.println();
		}
	}

	private List<List<Integer>> findLeaves(Node root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		helper(list, root);
		return list;
	}

	private int helper(List<List<Integer>> list, Node root) {
		if (root == null) {
			return -1;
		}

		int left = helper(list, root.left);
		int right = helper(list, root.right);

		int curr = Math.max(left, right) + 1;

		if (list.size() <= curr) {
			list.add(new ArrayList<Integer>());
		}

		list.get(curr).add(root.val);
		return curr;
	}

	private void inOrder(Node root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(" " + root.val);
		inOrder(root.right);
	}

	private Node initializeTree() {
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
