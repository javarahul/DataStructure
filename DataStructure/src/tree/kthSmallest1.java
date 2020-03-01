package tree;

import java.util.Scanner;
import java.util.Stack;

public class kthSmallest1 {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Inorder Traversal of the BST:-> ");
		Node tempRoot = root;
		printInorder(tempRoot);
		System.out.println();

		System.out.println("Enter which number smallest number want from BST:->");
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		int kthSmallest = getkthSmallest(root, k);

		System.out.println(k + "th" + "Smallest Element:-> " + kthSmallest);
	}

	private static void printInorder(Node root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}

	private static int getkthSmallest(Node root, int k) {
		int kthSmallest = 0;
		if (root == null) {
			return kthSmallest;
		}

		Stack<Node> stack = new Stack<>();

		Node ptr = root;

		while (!stack.isEmpty() || ptr != null) {
			if (ptr != null) {
				stack.push(ptr);
				ptr = ptr.left;
			} else {
				Node temp = stack.pop();
				k--;
				if (k == 0) {
					kthSmallest = temp.val;
				}
				ptr = temp.right;
			}
		}
		return kthSmallest;
	}

	private static Node initializeTree() {
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
