public class HeightBinaryTree {
	Node root = null;

	public static void main(String[] args) {
		HeightBinaryTree tree = new HeightBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Height of tree is : " + tree.getHeight(tree.root));
	}

	private static int getHeight(Node root) {
		if (root == null) {
			return -1;
		}

		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);

		return 1 + Math.max(leftHeight, rightHeight);
	}

}

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
