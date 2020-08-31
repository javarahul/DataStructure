package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointer3 {

	public static void main(String[] args) {
		LinkNode3 root = initializeTree();

		System.out.println("Preorder Traversal of the BST:-> ");
		LinkNode3 tempRoot = root;
		printPreorder(tempRoot);
		System.out.println();

		populatenextPointer(root);

		display(root);

	}

	private static void display(LinkNode3 root) {
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

	private static void populatenextPointer(LinkNode3 root) {
		if (root == null) {
			return;
		}

		Queue<LinkNode3> queue = new LinkedList<LinkNode3>();
		queue.add(root);

		queue.add(null);

		while (!queue.isEmpty()) {
			LinkNode3 currNode = queue.poll();

			if (currNode != null) {
				currNode.nextRight = queue.peek();

				if (currNode.left != null) {
					queue.add(currNode.left);
				}
				if (currNode.right != null) {
					queue.add(currNode.right);
				}
			} else if (!queue.isEmpty()) {
				queue.add(null);
			}
		}
	}

	private static LinkNode3 initializeTree() {
		LinkNode3 root = new LinkNode3(10);
		root.left = new LinkNode3(20);
		root.right = new LinkNode3(30);
		root.left.left = new LinkNode3(40);
		root.left.right = new LinkNode3(50);
		root.right.left = new LinkNode3(60);
		root.right.right = new LinkNode3(70);

		return root;
	}

	private static void printPreorder(LinkNode3 root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}
}

class LinkNode3 {
	int val;
	LinkNode3 left;
	LinkNode3 right;
	LinkNode3 nextRight;

	public LinkNode3(int val) {
		this.val = val;
		left = null;
		right = null;
		nextRight = null;
	}
}