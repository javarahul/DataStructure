package tree;

public class ValdateBST2 {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Inorder Traversal of the BST:-> ");
		Node tempRoot = root;
		printInorder(tempRoot);
		System.out.println();

		boolean isValidBST = isValidBST(root);
		System.out.println("Is this BST is valid: " + isValidBST);

	}

	private static boolean isValidBST(Node root) {
		return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}

	private static boolean isValidBST(Node root, double min, double max) {
		if (root == null) {
			return true;
		}

		if (root.val <= min || root.val >= max) {
			return false;
		}

		boolean isLeftBST = isValidBST(root.left, min, root.val);
		boolean isRightBST = isValidBST(root.right, root.val, max);

		if (!isLeftBST || !isRightBST) {
			return false;
		}
		return true;
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
