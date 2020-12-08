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
		Wrapper right = helper(node.right);

		curr.lower = Math.min(node.val, left.lower);
		curr.upper = Math.max(node.val, right.upper);

		if (left.isBST && right.isBST && left.upper <= node.val && right.lower >= node.val) {
			curr.size = left.size + right.size + 1;
			curr.isBST = true;
		} else {
			curr.size = Math.max(left.size, right.size);
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
