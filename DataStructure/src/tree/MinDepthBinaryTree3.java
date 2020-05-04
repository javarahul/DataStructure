package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthBinaryTree3 {

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

		Queue<Node> nodes = new LinkedList<Node>();
		Queue<Integer> depth = new LinkedList<Integer>();

		nodes.add(root);
		depth.add(1);

		while (!nodes.isEmpty()) {
			Node currNode = nodes.remove();
			int currDepth = depth.remove();

			if (currNode.left == null && currNode.right == null) {
				return currDepth;
			}

			if (currNode.left != null) {
				nodes.add(currNode.left);
				depth.add(currDepth + 1);
			}

			if (currNode.right != null) {
				nodes.add(currNode.right);
				depth.add(currDepth + 1);
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
}
