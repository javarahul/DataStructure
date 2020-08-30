package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointer2 {

	public static void main(String[] args) {
		LinkNode2 root = initializeTree();

		System.out.println("Preorder Traversal of the BST:-> ");
		LinkNode2 tempRoot = root;
		printPreorder(tempRoot);
		System.out.println();

		populatenextPointer(root);

		display(root);

	}

	private static void display(LinkNode2 root) {
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

	private static void populatenextPointer(LinkNode2 root) {
		if (root == null) {
			return;
		}

		Queue<LinkNode2> queue = new LinkedList<>();
		queue.add(root);

		LinkNode2 currNode = null;

		while (!queue.isEmpty()) {
			int currLevelSize = queue.size();

			for (int i = 0; i < currLevelSize; i++) {
				LinkNode2 prev = currNode;
				currNode = queue.poll();

				if (i > 0) {
					prev.nextRight = currNode;
				}
				if (currNode.left != null) {
					queue.add(currNode.left);
				}
				if (currNode.right != null) {
					queue.add(currNode.right);
				}
			}
			currNode.nextRight = null;
		}
	}

	private static LinkNode2 initializeTree() {
		LinkNode2 root = new LinkNode2(10);
		root.left = new LinkNode2(20);
		root.right = new LinkNode2(30);
		root.left.left = new LinkNode2(40);
		root.left.right = new LinkNode2(50);
		root.right.left = new LinkNode2(60);
		root.right.right = new LinkNode2(70);

		return root;
	}

	private static void printPreorder(LinkNode2 root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}
}

class LinkNode2 {
	int val;
	LinkNode2 left;
	LinkNode2 right;
	LinkNode2 nextRight;

	public LinkNode2(int val) {
		this.val = val;
		left = null;
		right = null;
		nextRight = null;
	}
}