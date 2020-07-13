package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightSideView2 {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Elements in PreOrder:-> ");
		printPreOrder(root);

		List<Integer> rightSideElements = getRigtSideViewElement(root);

		System.out.println();
		System.out.println("Right Side Element of Binary Tree:-> " + rightSideElements);
	}

	private static List<Integer> getRigtSideViewElement(Node root) {
		ArrayList<Integer> result = new ArrayList<>();

		LinkedList<Node> nodeQueue = new LinkedList<>();
		LinkedList<Integer> levelQueue = new LinkedList<>();

		if (root == null) {
			return result;
		}

		nodeQueue.offer(root);
		levelQueue.offer(1);

		int prevLevel = 0;

		while (!nodeQueue.isEmpty()) {
			Node currNode = nodeQueue.poll();
			Integer currNodelevel = levelQueue.poll();

			if (currNodelevel != prevLevel) {
				result.add(currNode.val);
			}

			if (currNode.right != null) {
				nodeQueue.offer(currNode.right);
				levelQueue.offer(currNodelevel + 1);
			}

			if (currNode.left != null) {
				nodeQueue.offer(currNode.left);
				levelQueue.offer(currNodelevel + 1);
			}

			prevLevel = currNodelevel;
		}

		return result;
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
