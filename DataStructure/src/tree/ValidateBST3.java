package tree;

public class ValidateBST3 {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Inorder Traversal of the BST:-> ");
		Node tempRoot = root;
		printInorder(tempRoot);
		System.out.println();

		boolean isValidBST = isValidBST(root, null, null);
		System.out.println("Is this BST is valid: " + isValidBST);
	}

	private static boolean isValidBST(Node root, Node left, Node right) {
		if (root == null) {
			return true;
		}

		if (left != null && left.val >= root.val) {
			return false;
		}

		if (right != null && right.val <= root.val) {
			return false;
		}

		return isValidBST(root.left, left, root) && isValidBST(root.right, root, right);
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
