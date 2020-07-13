package tree;

class MaxLeve {
	int maxLevel;
}

public class RightSideView3 {
	private static MaxLeve max = new MaxLeve();

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Elements in PreOrder:-> ");
		printPreOrder(root);
		
		System.out.println();

		RightSideView3 rightSideView3 = new RightSideView3();
		rightSideView3.getRightSideView(root);
	}

	private void getRightSideView(Node root) {
		getRigtSideViewElement(root, 1, max);
	}

	void getRigtSideViewElement(Node root, int level, MaxLeve maxLeve) {
		if (root == null) {
			return;
		}

		if (maxLeve.maxLevel < level) {
			System.out.println(root.val + " ");
			maxLeve.maxLevel = level;
		}

		getRigtSideViewElement(root.right, level + 1, maxLeve);
		getRigtSideViewElement(root.left, level + 1, maxLeve);
	}

	private static void printPreOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}

	private static void printInOrder(Node root) {
		if (root == null) {
			return;
		}
		printPreOrder(root.left);
		System.out.print(root.val + " ");
		printPreOrder(root.right);
	}

	private static Node initializeTree() {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.right.left = new Node(6);
		root.right.right = new Node(8);
		return root;
	}
}
