package tree;

public class SortedArrayToBST {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };

		Node root = buildBST(arr);

		System.out.println("After BST construction complete result in PostOrder:-> ");
		printPostOrder(root);
		System.out.println();

	}

	private static Node buildBST(int[] arr) {
		if (arr.length == 0) {
			return null;
		}
		return buildBST(arr, 0, arr.length - 1);
	}

	private static Node buildBST(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;
		Node root = new Node(arr[mid]);

		root.left = buildBST(arr, start, mid - 1);
		root.right = buildBST(arr, mid + 1, end);

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
