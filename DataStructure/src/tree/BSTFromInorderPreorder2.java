package tree;

import java.util.HashMap;

public class BSTFromInorderPreorder2 {

	public static void main(String[] args) {
		int inOrder[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
		int preOrder[] = new int[] { 1, 2, 4, 8, 5, 3, 6, 7 };

		int length = inOrder.length;

		System.out.println("PostOrder Traversal of the BST:-> ");
		Node root = buildBST(inOrder, preOrder, length);

		System.out.println("After BST construction complete result in PostOrder:-> ");
		printPostOrder(root);
		System.out.println();
	}

	private static Node buildBST(int[] inOrder, int[] preOrder, int length) {
		IndexForPre2 index = new IndexForPre2();
		index.index = 0;

		return buildBSTTree(inOrder, preOrder, 0, length - 1, index);
	}

	private static Node buildBSTTree(int[] inOrder, int[] preOrder, int inStart, int inEnd, IndexForPre2 IndexForPre2) {

		if (inStart > inEnd) {
			return null;
		}

		Node root = new Node(preOrder[IndexForPre2.index]);
		IndexForPre2.index++;

		if (inStart == inEnd) {
			return root;
		}

		int inIndex = 0;

		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == root.val) {
				inIndex = i;
				break;
			}
		}

		root.left = buildBSTTree(inOrder, preOrder, inStart, inIndex - 1, IndexForPre2);
		root.right = buildBSTTree(inOrder, preOrder, inIndex + 1, inEnd, IndexForPre2);

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

class IndexForPre2 {
	int index;
}
