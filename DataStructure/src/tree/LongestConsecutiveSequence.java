package tree;

import java.util.LinkedList;
import java.util.Scanner;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Inorder Traversal of the BST:-> ");
		Node tempRoot = root;
		printInorder(tempRoot);
		System.out.println();

		int longestConsecutiveSequence = getSequence(root);

		System.out.println("Longest Consecutive Sequence is:" + longestConsecutiveSequence);
	}

	private static int getSequence(Node root) {
		if (root == null) {
			return 0;
		}
		LinkedList<Node> nodes = new LinkedList<>();
		LinkedList<Integer> sizeList = new LinkedList<>();

		nodes.offer(root);
		sizeList.offer(1);
		int max = 1;

		while (!nodes.isEmpty()) {
			Node head = nodes.poll();
			Integer size = sizeList.poll();

			if (head.left != null) {
				int leftSize = size;
				if (head.val == head.left.val - 1) {
					leftSize++;
					max = Math.max(max, leftSize);
				} else {
					leftSize = 1;
				}
				nodes.offer(head.left);
				sizeList.offer(leftSize);
			}

			if (head.right != null) {
				int rightSize = size;
				if (head.val == head.right.val - 1) {
					rightSize++;
					max = Math.max(max, rightSize);
				} else {
					rightSize = 1;
				}
				nodes.offer(head.right);
				sizeList.offer(rightSize);
			}
		}
		return max;
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
