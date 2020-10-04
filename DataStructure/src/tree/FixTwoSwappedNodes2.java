package tree;

public class FixTwoSwappedNodes2 {
	private Node first, second, prev;

	public static void main(String[] args) {
		FixTwoSwappedNodes2 tree = new FixTwoSwappedNodes2();
		Node root = tree.initializeTree();
		System.out.println("Inorder Traversal" + " of the original tree");

		tree.printInorder(root);

		tree.recoverBST(root);

		System.out.println("\nInorder Traversal" + " of the fixed tree");
		tree.printInorder(root);
	}

	private void recoverBST(Node root) {
		first = null;
		second = null;
		prev = null;

		inOrder(root);

		if (first != null && second != null) {
			int temp = first.val;
			first.val = second.val;
			second.val = temp;
		}
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			if (prev == null) {
				prev = root;
			} else {
				if (root.val < prev.val) {
					if (first == null) {
						first = prev;
					}
					second = root;
				}
				prev = root;
			}
			inOrder(root.right);
		}
	}

	private Node initializeTree() {
		Node root = new Node(6);
		root.left = new Node(10);
		root.right = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.right = new Node(12);
		root.right.left = new Node(7);

		return root;
	}

	private void printInorder(Node root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}

}
