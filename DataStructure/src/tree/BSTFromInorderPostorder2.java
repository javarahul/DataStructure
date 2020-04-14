package tree;

public class BSTFromInorderPostorder2 {

	public static void main(String[] args) {
		int inOrder[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
		int postOrder[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };
		int length = inOrder.length;

		System.out.println("PreOrder Traversal of the BST:-> ");
		Node root = buildBST(inOrder, postOrder, length);

		System.out.println("After BST construction complete result in PreOrder:-> ");
		printPreOrder(root);
		System.out.println();
	}

	private static Node buildBST(int[] inOrder, int[] postOrder, int length) {
		Index index = new Index();
		index.index = length - 1;
		return buildBSTTree(inOrder, postOrder, 0, length - 1, index);
	}

	private static Node buildBSTTree(int[] inOrder, int[] postOrder, int inStart, int inEnd, Index postEnd) {
		if (inStart > inEnd) {
			return null;
		}

		Node root = new Node(postOrder[postEnd.index]);
		postEnd.index--;

		if (inStart == inEnd) {
			return root;
		}

		int rootIndexInInorder = 0;
		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == root.val) {
				rootIndexInInorder = i;
				break;
			}
		}

		root.right = buildBSTTree(inOrder, postOrder, rootIndexInInorder + 1, inEnd, postEnd);
		root.left = buildBSTTree(inOrder, postOrder, inStart, rootIndexInInorder - 1, postEnd);

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

class Index {
	int index;
}
