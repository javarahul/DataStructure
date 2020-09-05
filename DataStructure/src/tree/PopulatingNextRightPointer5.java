package tree;

public class PopulatingNextRightPointer5 {

	public static void main(String[] args) {
		LinkNode5 root = initializeTree();

		System.out.println("Preorder Traversal of the BST:-> ");
		LinkNode5 tempRoot = root;
		printPreorder(tempRoot);
		System.out.println();

		populatenextPointer(root);

		display(root);

	}

	private static void display(LinkNode5 root) {
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

	private static void populatenextPointer(LinkNode5 levels) {
		if (levels == null) {
			return;
		}

		levels.nextRight = null;

		while (levels != null) {
			LinkNode5 node = levels;

			while (node != null) {
				if (node.left != null) {
					if (node.right != null) {
						node.left.nextRight = node.right;
					} else {
						node.left.nextRight = getNextRight(node);
					}
				}
				if (node.right != null) {
					node.right.nextRight = getNextRight(node);
				}

				node = node.nextRight;
			}

			if (levels.left != null) {
				levels = levels.left;
			} else if (levels.right != null) {
				levels = levels.right;
			} else {
				levels = getNextRight(levels);
			}
		}
	}

	private static LinkNode5 getNextRight(LinkNode5 node) {
		LinkNode5 ptr = node.nextRight;
		while (ptr != null) {
			if (ptr.left != null) {
				return ptr.left;
			}
			if (ptr.right != null) {
				return ptr.right;
			}
			ptr = ptr.nextRight;
		}
		return null;
	}

	private static LinkNode5 initializeTree() {
		LinkNode5 root = new LinkNode5(10);
		root.left = new LinkNode5(20);
		root.right = new LinkNode5(30);
		root.left.left = new LinkNode5(40);
		root.left.right = new LinkNode5(50);
		root.right.left = new LinkNode5(60);
		root.right.right = new LinkNode5(70);

		return root;
	}

	private static void printPreorder(LinkNode5 root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}
}

class LinkNode5 {
	int val;
	LinkNode5 left;
	LinkNode5 right;
	LinkNode5 nextRight;

	public LinkNode5(int val) {
		this.val = val;
		left = null;
		right = null;
		nextRight = null;
	}
}