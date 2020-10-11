package tree;

public class InorderSuccessorBST2 {
	private static InorderSuccessorBST2 bst = new InorderSuccessorBST2();

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
		if (nodeSucc.right != null) {
			return minValue(nodeSucc.right);
		}

		Node succ = null;
		while (root != null) {
			if (nodeSucc.val < root.val) {
				succ = root;
				root = root.left;
			} else if (nodeSucc.val > root.val) {
				root = root.right;
			} else {
				break;
			}
		}
		return succ;
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