package tree;

public class PrintAllFromRootToLeaf {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Inorder Traversal of the BST:-> ");
		Node tempRoot = root;
		printInorder(tempRoot);
		System.out.println();

		printRootToLeaf(root);
	}

	private static void printRootToLeaf(Node root) {
		int path[] = new int[1000];

		printRootToLeaf(root, path, 0);
	}

	private static void printRootToLeaf(Node root, int[] path, int length) {
		if (root == null) {
			return;
		}

		path[length] = root.val;
		length++;

		if (root.left == null && root.right == null) {
			printPath(path, length);
		} else {
			printRootToLeaf(root.left, path, length);
			printRootToLeaf(root.right, path, length);
		}
	}

	private static void printPath(int[] path, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}

	private static Node initializeTree() {
		Node root = new Node(9);
		root.left = new Node(4);
		root.right = new Node(17);
		root.left.left = new Node(3);
		root.left.right = new Node(6);
		root.left.right.left = new Node(5);
		root.left.right.right = new Node(7);
		root.right.right = new Node(22);
		root.right.right.left = new Node(20);

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
