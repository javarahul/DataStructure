package tree;

public class SymmetricTree {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Elements in PreOrder:-> ");
		printPreOrder(root);

		boolean isSymmetric = isSymmetric(root);

		System.out.println();
		System.out.println("Binary Tree is Symmetric:-> " + isSymmetric);
	}

	private static boolean isSymmetric(Node root) {
		return isSymmetric(root, root);
	}

	private static boolean isSymmetric(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 != null && root2 != null && root1.val == root2.val) {
			return (isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left));
		}
		return false;
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
