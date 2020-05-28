package tree;

public class MaxPathSum {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Elements in PreOrder:-> ");
		printPreOrder(root);

		int maxPathSum = getMaxPathSum(root);

		System.out.println();
		System.out.println("Max Path Sum of Binary Tree:-> " + maxPathSum);
	}

	private static int getMaxPathSum(Node root) {
		int max[] = new int[1];
		max[0] = Integer.MIN_VALUE;
		helper(root, max);
		return max[0];
	}

	private static int helper(Node root, int[] max) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left, max);
		int right = helper(root.right, max);

		int current = Math.max(root.val, Math.max(left + root.val, right + root.val));

		max[0] = Math.max(max[0], Math.max(current, left + right + root.val));

		return current;
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
