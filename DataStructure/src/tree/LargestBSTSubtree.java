package tree;

public class LargestBSTSubtree {
	Value mVal = new Value();

	public static void main(String[] args) {
		LargestBSTSubtree tree = new LargestBSTSubtree();
		Node root = tree.initializeTree();
		
		System.out.println("Size of largest BST:-> " + tree.largestBST(root));
	}

	int largestBST(Node node) {
		largestBST(node, mVal, mVal, mVal, mVal);
		return mVal.maxSize;

	}

	private int largestBST(Node node, Value minRef, Value maxRef, Value maxSizeRef, Value isBSTRef) {
		if (node == null) {
			isBSTRef.isBST = true;
			return 0;
		}
		int min = Integer.MAX_VALUE;

		boolean leftFlag = false;
		boolean rightFlag = false;

		int ls, rs;

		maxRef.max = Integer.MIN_VALUE;

		ls = largestBST(node.left, minRef, maxRef, maxSizeRef, isBSTRef);

		if (isBSTRef.isBST && node.val > maxRef.max) {
			leftFlag = true;
		}

		min = minRef.min;
		minRef.min = Integer.MAX_VALUE;

		rs = largestBST(node.right, minRef, maxRef, maxSizeRef, isBSTRef);

		if (isBSTRef.isBST && node.val < minRef.min) {
			rightFlag = true;
		}

		if (min < minRef.min) {
			minRef.min = min;
		}
		if (node.val < minRef.min) {
			minRef.min = node.val;
		}
		if (node.val > maxRef.max) {
			maxRef.max = node.val;
		}

		if (leftFlag && rightFlag) {
			if (ls + rs + 1 > maxSizeRef.maxSize) {
				maxSizeRef.maxSize = ls + rs + 1;
			}
			return ls + rs + 1;
		} else {
			isBSTRef.isBST = false;
			return 0;
		}
	}

	private Node initializeTree() {
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
}

class Value {
	int maxSize = 0;
	boolean isBST = false;
	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;
}
