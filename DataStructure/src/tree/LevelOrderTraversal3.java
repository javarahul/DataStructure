package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal3 {

	public static void main(String[] args) {
		Node root = initializeTree();

		printLevelOrderTraversal(root);
	}

	private static void printLevelOrderTraversal(Node root) {
		int height = getHeight(root);
		for (int level = 1; level <= height; level++) {
			printGivenList(root, level);
		}
	}

	private static void printGivenList(Node root, int level) {
		if (root == null) {
			return;
		}

		if (level == 1) {
			System.out.print(root.val + " ");
		} else if (level > 1) {
			System.out.println();
			printGivenList(root.left, level - 1);
			printGivenList(root.right, level - 1);
		}
	}

	private static int getHeight(Node root) {
		if (root == null) {
			return 0;
		}

		int leftTreeHeight = getHeight(root.left);
		int rightTreeHeight = getHeight(root.right);

		if (leftTreeHeight > rightTreeHeight) {
			return (leftTreeHeight + 1);
		} else {
			return (rightTreeHeight + 1);
		}
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
