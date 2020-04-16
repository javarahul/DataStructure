package tree;

import java.util.HashMap;

public class BSTFromInorderPreorder1 {

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
		IndexForPre index = new IndexForPre();
		index.index = 0;

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			map.put(inOrder[i], i);
		}
		return buildBSTTree(inOrder, preOrder, 0, length - 1, index, map);
	}

	private static Node buildBSTTree(int[] inOrder, int[] preOrder, int inStart, int inEnd, IndexForPre indexForPre,
			HashMap<Integer, Integer> map) {

		if (inStart > inEnd) {
			return null;
		}

		Node root = new Node(preOrder[indexForPre.index]);
		indexForPre.index++;

		if (inStart == inEnd) {
			return root;
		}

		int inIndex = map.get(root.val);

		root.left = buildBSTTree(inOrder, preOrder, inStart, inIndex - 1, indexForPre, map);
		root.right = buildBSTTree(inOrder, preOrder, inIndex + 1, inEnd, indexForPre, map);

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

class IndexForPre {
	int index;
}
