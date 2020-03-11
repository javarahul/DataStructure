package tree;

public class LongestConsecutiveSequenceDFS {
	private static int max = 0;

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Inorder Traversal of the BST:-> ");
		Node tempRoot = root;
		printInorder(tempRoot);
		System.out.println();

		int longestConsecutiveSequence = getSequence(root);

		System.out.println("Longest Consecutive Sequence is:" + longestConsecutiveSequence);

	}

	private static int getSequence(Node root) {
		if (root == null) {
			return 0;
		}
		int leftMax = getSequence(root.left);
		int rightMax = getSequence(root.right);

		int leftTotal = 0;
		if (root.left == null) {
			leftTotal = 1;
		} else if (root.val + 1 == root.left.val) {
			leftTotal++;
		} else {
			leftTotal = 1;
		}

		int rightTotal = 0;
		if (root.right == null) {
			rightTotal = 1;
		} else if (root.val + 1 == root.right.val) {
			rightTotal++;
		} else {
			rightTotal = 1;
		}
		max = Math.max(max, leftTotal);
        max = Math.max(max, rightTotal);
 
        int longer = Math.max(leftTotal, rightTotal);   
 
        return longer;
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

	private static void printInorder(Node root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}
}
