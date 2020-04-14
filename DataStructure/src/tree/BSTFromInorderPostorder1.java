package tree;

public class BSTFromInorderPostorder1 {

	public static void main(String[] args) {
		int inOrder[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
		int postOrder[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };

		System.out.println("PreOrder Traversal of the BST:-> ");
		Node root = buildBST(inOrder, postOrder);

		System.out.println("After BST construction complete result in PreOrder:-> ");
		printPreOrder(root);
		System.out.println();
	}

	private static Node buildBST(int[] inOrder, int[] postOrder) {
		int inStart = 0;
		int inEnd = inOrder.length - 1;
		int postStart = 0;
		int postEnd = postOrder.length - 1;
		return buildBSTTree(inOrder, inStart, inEnd, postOrder, postStart, postEnd);
	}

	private static Node buildBSTTree(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart,
			int postEnd) {
		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}

		int rootNodeVal = postOrder[postEnd];
		Node root = new Node(rootNodeVal);

		int rootIndexInInorder = 0;

		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == rootNodeVal) {
				rootIndexInInorder = i;
				break;
			}
		}

		root.left = buildBSTTree(inOrder, inStart, rootIndexInInorder - 1, postOrder, postStart,
				postStart + rootIndexInInorder - (inStart + 1));
		root.right = buildBSTTree(inOrder, rootIndexInInorder + 1, inEnd, postOrder,
				postStart + rootIndexInInorder - inStart, postEnd - 1);
		return root;
	}

	private static void printPreOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}
}
