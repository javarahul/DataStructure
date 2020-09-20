package tree;

import java.util.ArrayList;
import java.util.Scanner;

public class ConstructUniqueBST1 {

	public static void main(String[] args) {
		System.out.println("Enter number till which we need to make BST:-> ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		ArrayList<Node> totalTreesFrom1toN = constructBST(1, n);
		System.out.println("Preorder Traversal for all created BST:->");

		for (int i = 0; i < totalTreesFrom1toN.size(); i++) {
			preOrder(totalTreesFrom1toN.get(i));
			System.out.println();
		}
	}

	private static void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.val + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	private static ArrayList<Node> constructBST(int start, int end) {
		ArrayList<Node> list = new ArrayList<>();

		if (start > end) {
			list.add(null);
			return list;
		}

		for (int i = start; i <= end; i++) {
			ArrayList<Node> leftSubTree = constructBST(start, i - 1);
			ArrayList<Node> rightSubTree = constructBST(i + 1, end);

			for (int j = 0; j < leftSubTree.size(); j++) {
				Node left = leftSubTree.get(j);
				for (int k = 0; k < rightSubTree.size(); k++) {
					Node right = rightSubTree.get(k);

					Node node = new Node(i);
					node.left = left;
					node.right = right;

					list.add(node);
				}
			}
		}
		return list;
	}
}
