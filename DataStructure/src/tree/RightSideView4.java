package tree;

import java.util.LinkedList;
import java.util.Queue;

public class RightSideView4 {
	private static MaxLeve max = new MaxLeve();

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Elements in PreOrder:-> ");
		printPreOrder(root);

		System.out.println();

		getRightSideView(root);
	}

	private static void getRightSideView(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int n = queue.size();

			for (int i = 0; i < n; i++) {
				Node curNode = queue.poll();
				
				if (i == n-1){
					System.out.println(curNode.val + " ");
				}
				
				if(curNode.left!=null){
					queue.add(curNode.left);
				}
				
				if (curNode.right!=null){
					queue.add(curNode.right);
				}
			}
		}
	}

	private static void printPreOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}

	private static void printInOrder(Node root) {
		if (root == null) {
			return;
		}
		printPreOrder(root.left);
		System.out.print(root.val + " ");
		printPreOrder(root.right);
	}

	private static Node initializeTree() {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.right.left = new Node(6);
		root.right.right = new Node(8);
		return root;
	}
}
