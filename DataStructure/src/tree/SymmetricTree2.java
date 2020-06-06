package tree;

public class SymmetricTree2 {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Elements in PreOrder:-> ");
		printPreOrder(root);

		boolean isSymmetric = isSymmetric(root);

		System.out.println();
		System.out.println("Binary Tree is Symmetric:-> " + isSymmetric);
	}

	private static boolean isSymmetric(Node root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}

	private static boolean isSymmetric(Node leftNode, Node rightNode) {
		if (leftNode == null && rightNode == null) {
			return true;
		}

		if (rightNode == null || leftNode == null) {
			return false;
		}

		if (leftNode.left != rightNode.right) {
			return false;
		}

		if (!isSymmetric(leftNode.left, rightNode.right)) {
			return false;
		}

		if (!isSymmetric(leftNode.right, rightNode.left)) {
			return false;
		}
		return true;
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
