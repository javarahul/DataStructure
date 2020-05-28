package tree;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Elements in PreOrder:-> ");
		printPreOrder(root);

		boolean isBalancedTree = getBalancedTree(root);

		System.out.println();
		System.out.println("Binary Tree is Balanced:-> " + isBalancedTree);
	}

	private static boolean getBalancedTree(Node root) {
		if (root == null) {
			return true;
		}

		if (getHeight(root) == -1) {
			return false;
		}
		return true;
	}

	private static int getHeight(Node root) {
		if (root == null) {
			return 0;
		}

		int left = getHeight(root.left);
		int right = getHeight(root.right);

		if (left == -1 || right == -1) {
			return -1;
		}

		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}

	private static void printPreOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);
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
