package tree;

import java.util.LinkedList;
import java.util.Scanner;

public class SumRootToLeaf {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Inorder Traversal of the BST:-> ");
		Node tempRoot = root;
		printInorder(tempRoot);
		System.out.println();

		int total = getSumFromRootToLeaf(root, 0);

		System.out.println("Sum from Root to leaf:-> " + total);
	}

	private static int getSumFromRootToLeaf(Node node, int curVal) {
		if (node == null) {
			return 0;
		}

		curVal = (curVal * 10 + node.val);

		if (node.left == null && node.right == null) {
			return curVal;
		}

		return getSumFromRootToLeaf(node.left, curVal) + getSumFromRootToLeaf(node.right, curVal);
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

	private static void printInorder(Node root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}
}
