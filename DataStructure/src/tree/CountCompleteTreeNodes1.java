package tree;

public class CountCompleteTreeNodes1 {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Inorder Traversal of the BST:-> ");
		Node tempRoot = root;
		printInorder(tempRoot);
		System.out.println();

		int total = getCountCompleteTreeNodes(root);

		System.out.println("Sum from Root to leaf:-> " + total);
	}

	private static int getCountCompleteTreeNodes(Node root) {
		if (root == null) {
			return 0;
		}

		return 1 + getCountCompleteTreeNodes(root.left) + getCountCompleteTreeNodes(root.right);
	}

	private static Node initializeTree() {
		Node root = new Node(6);
		root.left = new Node(3);
		root.right = new Node(5);
		root.right.right = new Node(4);
		root.left.left = new Node(2);
		root.left.right = new Node(5);
		root.left.right.right = new Node(4);
		root.left.right.left = new Node(7);

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
