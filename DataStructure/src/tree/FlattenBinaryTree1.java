package tree;

import java.util.Stack;

public class FlattenBinaryTree1 {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Inorder Traversal of the BST:-> ");
		Node tempRoot = root;
		printInorder(tempRoot);
		System.out.println();

		falttenTree(root);

		System.out.println("After Flatten BST:-> ");
		printInorder(root);
		System.out.println();
	}

	private static void falttenTree(Node root) {
		Stack<Node> stack = new Stack<>();
		Node ptr = root;

		while (ptr != null || !stack.isEmpty()) {
			if (ptr.right != null) {
				stack.push(ptr.right);
			}

			if (ptr.left != null) {
				ptr.right = ptr.left;
				ptr.left = null;
			} else if (!stack.isEmpty()) {
				Node temp = stack.pop();
				ptr.right = temp;
			}
			ptr = ptr.right;
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

	private static void printInorder(Node root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}
}
