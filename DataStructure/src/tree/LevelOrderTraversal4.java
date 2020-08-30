package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.management.Query;

public class LevelOrderTraversal4 {

	public static void main(String[] args) {
		Node root = initializeTree();

		printLevelOrderTraversal(root);
	}

	private static void printLevelOrderTraversal(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node head = queue.poll();
			System.out.print(head.val + " ");

			if (head.left != null) {
				queue.add(head.left);
			}

			if (head.right != null) {
				queue.add(head.right);
			}
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
