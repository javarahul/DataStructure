package tree;

public class MinDepthBinaryTree {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Elements in PreOrder:-> ");
		printPreOrder(root);

		int minDepth = getMinDepth(root);
		
		System.out.println("Min depth of Binary Tree:-> " + minDepth);
	}

	private static int getMinDepth(Node root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		if (root.left == null) {
			return getMinDepth(root.right) + 1;
		}

		if (root.right == null) {
			return getMinDepth(root.left) + 1;
		}

		return Math.min(getMinDepth(root.left), getMinDepth(root.right)) + 1;
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
