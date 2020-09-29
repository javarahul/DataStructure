package tree;

public class CountCompleteTreeNodes2 {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Inorder Traversal of the BST:-> ");
		Node tempRoot = root;
		printInorder(tempRoot);
		System.out.println();

		int total = getCountCompleteTreeNodes(root);

		System.out.println("Total Available Nodes in tree:-> " + total);
	}

	private static int getCountCompleteTreeNodes(Node root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = getLeftHeight(root);
		int rightHeight = getRightHeight(root);

		if (leftHeight == rightHeight) {
			return (2 << (leftHeight - 1)) - 1;
		} else {
			return 1 + getCountCompleteTreeNodes(root.left) + getCountCompleteTreeNodes(root.right);
		}
	}

	private static int getRightHeight(Node root) {
		if (root == null) {
			return 0;
		}

		int height = 0;
		while (root.right != null) {
			height++;
			root = root.right;
		}
		return height;
	}

	private static int getLeftHeight(Node root) {
		if (root == null) {
			return 0;
		}

		int height = 0;
		while (root.left != null) {
			height++;
			root = root.left;
		}
		return height;
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
