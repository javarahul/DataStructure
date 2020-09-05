package tree;

public class PopulatingNextRightPointer6 {

	public static void main(String[] args) {
		LinkNode6 root = initializeTree();

		System.out.println("Preorder Traversal of the BST:-> ");
		LinkNode6 tempRoot = root;
		printPreorder(tempRoot);
		System.out.println();

		populatenextPointer(root);

		display(root);

	}

	private static void display(LinkNode6 root) {
		// Let us check the values of next pointers
		int a = root.nextRight != null ? root.nextRight.val : -1;
		int b = root.left.nextRight != null ? root.left.nextRight.val : -1;
		int c = root.right.nextRight != null ? root.right.nextRight.val : -1;
		int d = root.left.left.nextRight != null ? root.left.left.nextRight.val : -1;
		int e = root.right.right.nextRight != null ? root.right.right.nextRight.val : -1;

		// Now lets print the values
		System.out
				.println("Following are populated next pointers in " + " the tree(-1 is printed if there is no next)");
		System.out.println("next of " + root.val + " is " + a);
		System.out.println("next of " + root.left.val + " is " + b);
		System.out.println("next of " + root.right.val + " is " + c);
		System.out.println("next of " + root.left.left.val + " is " + d);
		System.out.println("next of " + root.right.right.val + " is " + e);
	}

	private static void populatenextPointer(LinkNode6 node) {
		if (node == null) {
			return;
		}
		LinkNode6 lastHead = node;
		LinkNode6 lastCurr = null;
		LinkNode6 currHead = null;
		LinkNode6 curr = null;

		while (lastHead != null) {
			lastCurr = lastHead;
			while (lastCurr != null) {
				if (currHead == null) {
					currHead = lastCurr.left;
					curr = lastCurr.left;
				} else {
					curr.nextRight = lastCurr.left;
					curr = curr.nextRight;
				}

				if (currHead != null) {
					curr.nextRight = lastCurr.right;
					curr = curr.nextRight;
				}
				lastCurr = lastCurr.nextRight;
			}
			lastHead = currHead;
			currHead = null;
		}
	}

	private static LinkNode6 initializeTree() {
		LinkNode6 root = new LinkNode6(10);
		root.left = new LinkNode6(20);
		root.right = new LinkNode6(30);
		root.left.left = new LinkNode6(40);
		root.left.right = new LinkNode6(50);
		root.right.left = new LinkNode6(60);
		root.right.right = new LinkNode6(70);

		return root;
	}

	private static void printPreorder(LinkNode6 root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}
}

class LinkNode6 {
	int val;
	LinkNode6 left;
	LinkNode6 right;
	LinkNode6 nextRight;

	public LinkNode6(int val) {
		this.val = val;
		left = null;
		right = null;
		nextRight = null;
	}
}