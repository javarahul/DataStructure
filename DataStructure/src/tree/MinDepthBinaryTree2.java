package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthBinaryTree2 {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Elements in PreOrder:-> ");
		printPreOrder(root);

		int minDepth = getMinDepth(root);

		System.out.println("Min depth of Binary Tree:-> " + minDepth);
	}

	private static int getMinDepth(Node root) {
		return getMinDepth(root, 1);
	}

	private static int getMinDepth(Node root, int level) {
		if (root == null) {
			return level;
		}

		level++;

		return Math.min(getMinDepth(root.left, level), getMinDepth(root.right, level));
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
