package tree;

public class FixTwoSwappedNodes {
	private Node first, middle, prev, last;

	public static void main(String[] args) {
		FixTwoSwappedNodes tree = new FixTwoSwappedNodes();
		Node root = tree.initializeTree();
		System.out.println("Inorder Traversal" + " of the original tree");

		tree.printInorder(root);

		tree.correctBST(root);

		System.out.println("\nInorder Traversal" + " of the fixed tree");
		tree.printInorder(root);
	}

	private void correctBST(Node root) {
		first = null;
		middle = null;
		prev = null;
		last = null;

		correctTree(root);

		if (first != null && last != null) {
			int temp = first.val;
			first.val = last.val;
			last.val = temp;
		} else if (first != null && middle != null) {
			int temp = first.val;
			first.val = middle.val;
			middle.val = temp;
		}
	}

	private void correctTree(Node root) {
		if (root != null) {
			correctTree(root.left);
			if (prev != null && root.val < prev.val) {
				if (first == null) {
					first = prev;
					middle = root;
				} else {
					last = root;
				}
			}
			prev = root;
			correctTree(root.right);
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
