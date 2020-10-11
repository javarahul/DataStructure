package tree;

public class InorderSuccessorBST {
	private static InorderSuccessorBST bst = new InorderSuccessorBST();

	public static void main(String[] args) {
		NodeInOrderSucc root = bst.initializeTree();

		System.out.println("Tree in InOrder:-> ");
		bst.inOrder(root);
		System.out.println();

		NodeInOrderSucc nodeSucc = root.left.right.right;
		NodeInOrderSucc successor = bst.getInOrderSuccessor(root, nodeSucc);

		if (successor != null) {
			System.out.println("InOder Successor of " + nodeSucc.val + " is " + successor.val);
		} else {
			System.out.println("InOder Successor of " + nodeSucc.val + " does not exist");
		}
	}

	private NodeInOrderSucc getInOrderSuccessor(NodeInOrderSucc root, NodeInOrderSucc nodeSucc) {
		if (nodeSucc.right != null) {
			return minValue(nodeSucc.right);
		}

		NodeInOrderSucc curr = nodeSucc.parent;
		while (curr != null && nodeSucc == curr.right) {
			nodeSucc = curr;
			curr = curr.parent;
		}
		return curr;
	}

	private NodeInOrderSucc minValue(NodeInOrderSucc node) {
		NodeInOrderSucc curr = node;
		while (curr != null) {
			curr = curr.left;
		}
		return curr;
	}

	private void inOrder(NodeInOrderSucc root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(" " + root.val);
		inOrder(root.right);
	}

	private NodeInOrderSucc initializeTree() {
		NodeInOrderSucc root = null;
		root = bst.insert(root, 20);
		root = bst.insert(root, 8);
		root = bst.insert(root, 22);
		root = bst.insert(root, 4);
		root = bst.insert(root, 12);
		root = bst.insert(root, 10);
		root = bst.insert(root, 14);
		return root;
	}

	private NodeInOrderSucc insert(NodeInOrderSucc root, int item) {
		if (root == null) {
			return new NodeInOrderSucc(item);
		}
		NodeInOrderSucc temp = null;

		if (item < root.val) {
			temp = insert(root.left, item);
			root.left = temp;
			temp.parent = root;
		} else {
			temp = insert(root.right, item);
			root.right = temp;
			temp.parent = root;
		}
		return root;
	}
}

class NodeInOrderSucc {
	int val;
	NodeInOrderSucc left;
	NodeInOrderSucc right;
	NodeInOrderSucc parent;

	NodeInOrderSucc(int item) {
		val = item;
		left = null;
		right = null;
		parent = null;
	}
}
