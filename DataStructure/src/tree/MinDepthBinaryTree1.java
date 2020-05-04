package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthBinaryTree1 {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Elements in PreOrder:-> ");
		printPreOrder(root);

		int minDepth = getMinDepth(root);

		System.out.println("Min depth of Binary Tree:-> " + minDepth);
	}

	private static int getMinDepth(Node root) {
		if (root == null) {
			return 0;
		}

		Queue<QItem> queue = new LinkedList<MinDepthBinaryTree1.QItem>();
		QItem qItem = new QItem(root, 1);

		queue.add(qItem);

		while (!queue.isEmpty()) {
			qItem = queue.peek();
			queue.remove();

			Node node = qItem.node;
			int depth = qItem.depth;

			if (node.left == null && node.right == null) {
				return depth;
			}

			if (node.left != null) {
				qItem.node = node.left;
				qItem.depth = depth + 1;
				queue.add(qItem);
			}

			if (node.right != null) {
				qItem.node = node.right;
				qItem.depth = depth + 1;
				queue.add(qItem);
			}
		}
		return 0;
	}

	private static void printPreOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);
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

	static class QItem {
		Node node;
		int depth;

		public QItem(Node node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}
}
