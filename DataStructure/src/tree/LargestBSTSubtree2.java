package tree;

public class LargestBSTSubtree2 {

	public static void main(String[] args) {
		LargestBSTSubtree2 tree = new LargestBSTSubtree2();
		Node root = tree.initializeTree();
		System.out.println("Size of largest BST:-> " + tree.largestBSTSubtree(root));
	}

	private int largestBSTSubtree(Node root) {
		return helper(root).size;
	}

	private Wrapper helper(Node node) {
		Wrapper curr = new Wrapper();

		if (node == null) {
			curr.isBST = true;
			return curr;
		}

		Wrapper left = helper(node.left);
		Wrapper r = helper(node.right);

		curr.lower = Math.min(node.val, left.lower);
		curr.upper = Math.max(node.val, r.upper);

		if (left.isBST && r.isBST && left.upper <= node.val && r.lower >= node.val) {
			curr.size = left.size + r.size + 1;
			curr.isBST = true;
		} else {
			curr.size = Math.max(left.size, r.size);
			curr.isBST = false;
		}
		return curr;
	}

	private Node initializeTree() {
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

class Wrapper {
	int size = 0;
	boolean isBST = false;
	int lower = Integer.MAX_VALUE;
	int upper = Integer.MIN_VALUE;
}
