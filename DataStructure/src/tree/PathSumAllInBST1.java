package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathSumAllInBST1 {

	public static void main(String[] args) {
		Node root = initializeTree();

		System.out.println("Inorder Traversal of the BST:-> ");
		Node tempRoot = root;
		printInorder(tempRoot);
		System.out.println();

		System.out.println("Enetr the sum which for which we need Path:-> ");
		Scanner scanner = new Scanner(System.in);
		int sum = scanner.nextInt();

		List<ArrayList<Integer>> results = pathSum(root, sum);

		System.out.println("path is avialble for the given sum:-> " + results.size());

		for (int i = 0; i < results.size(); i++) {
			ArrayList<Integer> list = results.get(i);
			System.out.println("List is/are:-> ");
			System.out.println(list);
		}
	}

	private static List<ArrayList<Integer>> pathSum(Node root, int sum) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

		if (root == null) {
			return results;
		}
		ArrayList<Integer> list = new ArrayList<>();
		list.add(root.val);

		dfs(root, sum - root.val, results, list);
		return results;
	}

	private static void dfs(Node root, int sum, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> list) {
		if (root.left == null && root.right == null && sum == 0) {
			ArrayList<Integer> tempList = new ArrayList<>();
			tempList.addAll(list);
			results.add(tempList);
		}

		if (root.left != null) {
			list.add(root.left.val);
			dfs(root.left, sum - root.left.val, results, list);
			list.remove(list.size() - 1);
		}

		if (root.right != null) {
			list.add(root.right.val);
			dfs(root.right, sum - root.right.val, results, list);
			list.remove(list.size() - 1);
		}
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

	private static void printInorder(Node root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}
}
