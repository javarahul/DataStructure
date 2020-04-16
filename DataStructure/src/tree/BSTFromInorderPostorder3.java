package tree;

import java.util.HashMap;

public class BSTFromInorderPostorder3 {

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
		Index3 Index3 = new Index3();
		Index3.Index3 = length - 1;

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			map.put(inOrder[i], i);
		}
		return buildBSTTree(inOrder, postOrder, 0, length - 1, Index3, map);
	}

	private static Node buildBSTTree(int[] inOrder, int[] postOrder, int inStart, int inEnd, Index3 postEnd,
			HashMap<Integer, Integer> map) {
		if (inStart > inEnd) {
			return null;
		}

		Node root = new Node(postOrder[postEnd.Index3]);
		postEnd.Index3--;

		if (inStart == inEnd) {
			return root;
		}

		int rootIndex3InInorder = map.get(root.val);
		root.right = buildBSTTree(inOrder, postOrder, rootIndex3InInorder + 1, inEnd, postEnd, map);
		root.left = buildBSTTree(inOrder, postOrder, inStart, rootIndex3InInorder - 1, postEnd, map);

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

class Index3 {
	int Index3;
}
