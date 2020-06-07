package tree;

import java.util.Stack;

public class BSTIterator {
	private Stack<Node> mStack;

	public BSTIterator(Node root) {
		mStack = new Stack<>();
		while (root != null) {
			mStack.push(root);
			root = root.left;
		}
	}

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Elements in PreOrder:-> ");
		printPreOrder(root);

		bstIterator(root);
	}

	private static void bstIterator(Node root) {
		BSTIterator iterator = new BSTIterator(root);
		System.out.println();
		System.out.println("Item from Iterator");
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}

	public int next() {
		Node node = mStack.pop();
		int result = node.val;
		if (node.right != null) {
			node = node.right;
			while (node != null) {
				mStack.push(node);
				node = node.left;
			}
		}
		return result;
	}

	public boolean hasNext() {
		return !mStack.isEmpty();
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
