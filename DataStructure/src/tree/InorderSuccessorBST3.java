package tree;

public class InorderSuccessorBST3 {
	private static InorderSuccessorBST3 bst = new InorderSuccessorBST3();

	public static void main(String[] args) {
		Node root = bst.initializeTree();

		System.out.println("Tree in InOrder:-> ");
		bst.inOrder(root);
		System.out.println();

		Node nodeSucc = root.left.right.right;
		Node successor = bst.getInOrderSuccessor(root, nodeSucc);

		if (successor != null) {
			System.out.println("InOder Successor of " + nodeSucc.val + " is " + successor.val);
		} else {
			System.out.println("InOder Successor of " + nodeSucc.val + " does not exist");
		}
	}

	private Node getInOrderSuccessor(Node root, Node nodeSucc) {
		if (root == null) {
			return null;
		}

		Node curr = root;
		Node next = null;

		while (curr != null && curr.val != nodeSucc.val) {
			if (nodeSucc.val < curr.val) {
				next = curr;
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}

		if (curr == null) {
			return null;
		}

		if (curr.right == null) {
			return next;
		}

		curr = curr.right;
		while (curr.left != null) {
			curr = curr.left;
		}
		return curr;
	}

	private Node minValue(Node node) {
		Node curr = node;
		while (curr != null) {
			curr = curr.left;
		}
		return curr;
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