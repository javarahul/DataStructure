package tree;

public class PrintLeafNodes {

	public static void main(String[] args) {
		PrintLeafNodes tree = new PrintLeafNodes();
		Node root = tree.initializeTree();

		System.out.println("Tree in InOrder:-> ");
		tree.inOrder(root);
		System.out.println();

		tree.printLeafNodes(root);
	}

	private void printLeafNodes(Node root) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			System.out.print(" " + root.val);
		}

		if (root.left != null) {
			printLeafNodes(root.left);
		}

		if (root.right != null) {
			printLeafNodes(root.right);
		}
	}

	private void inOrder(Node root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(" " + root.val);
		inOrder(root.right);
	}

	private Node initializeTree() {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		return root;
	}
}
