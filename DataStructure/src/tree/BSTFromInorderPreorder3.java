package tree;

import java.util.HashMap;

public class BSTFromInorderPreorder3 {

	public static void main(String[] args) {
		int inOrder[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
		int preOrder[] = new int[] { 1, 2, 4, 8, 5, 3, 6, 7 };

		System.out.println("PostOrder Traversal of the BST:-> ");
		Node root = buildBST(inOrder, preOrder);

		System.out.println("After BST construction complete result in PostOrder:-> ");
		printPostOrder(root);
		System.out.println();
	}

	private static Node buildBST(int[] inOrder, int[] preOrder) {
		int inStart = 0;
		int inEnd = inOrder.length - 1;
		int preStart = 0;
		int preEnd = preOrder.length - 1;

		return buildBSTTree(preOrder, preStart, preEnd, inOrder, inStart, inEnd);
	}

	private static Node buildBSTTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {

		if (inStart > inEnd || preStart > preEnd) {
			return null;
		}

		int rootVal = preOrder[preStart];

		Node root = new Node(rootVal);

		int inIndex = 0;

		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == root.val) {
				inIndex = i;
				break;
			}
		}

		root.left = buildBSTTree(preOrder, preStart + 1, preStart + (inIndex - inStart), inOrder, inStart, inIndex - 1);
		root.right = buildBSTTree(preOrder, preStart + (inIndex - inStart) + 1, preEnd, inOrder, inIndex + 1, inEnd);

		return root;
	}

	private static void printPostOrder(Node root) {
		if (root == null) {
			return;
		}
		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.print(root.val + " ");
	}
}

