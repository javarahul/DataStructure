package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointer4 {

	public static void main(String[] args) {
		LinkNode4 root = initializeTree();

		System.out.println("Preorder Traversal of the BST:-> ");
		LinkNode4 tempRoot = root;
		printPreorder(tempRoot);
		System.out.println();

		populatenextPointer(root);

		display(root);

	}

	private static void display(LinkNode4 root) {
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

	private static void populatenextPointer(LinkNode4 node) {
		if (node == null) {
			return;
		}

		if (node.nextRight != null) {
			populatenextPointer(node.nextRight);
		}

		if (node.left != null) {
			if (node.right != null) {
				node.left.nextRight = node.right;
				node.right.nextRight = getNextRight(node);
			} else {
				node.left.nextRight = getNextRight(node);
			}
			populatenextPointer(node.left);
		} else if (node.right != null) {
			node.right.nextRight = getNextRight(node);
			populatenextPointer(node.right);
		} else {
			populatenextPointer(getNextRight(node));
		}
	}

	private static LinkNode4 getNextRight(LinkNode4 node) {
		LinkNode4 ptr = node.nextRight;
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

	private static LinkNode4 initializeTree() {
		LinkNode4 root = new LinkNode4(10);
		root.left = new LinkNode4(20);
		root.right = new LinkNode4(30);
		root.left.left = new LinkNode4(40);
		root.left.right = new LinkNode4(50);
		root.right.left = new LinkNode4(60);
		root.right.right = new LinkNode4(70);

		return root;
	}

	private static void printPreorder(LinkNode4 root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}
}

class LinkNode4 {
	int val;
	LinkNode4 left;
	LinkNode4 right;
	LinkNode4 nextRight;

	public LinkNode4(int val) {
		this.val = val;
		left = null;
		right = null;
		nextRight = null;
	}
}