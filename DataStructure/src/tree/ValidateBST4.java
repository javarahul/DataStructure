package tree;

public class ValidateBST4 {
	private static Node prev;

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
		if (root != null) {
			if (!isValidBST(root.left)) {
				return false;
			}
			if (prev != null && root.val <= prev.val) {
				return false;
			}
			prev = root;
			return isValidBST(root.right);
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
