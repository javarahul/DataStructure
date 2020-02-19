package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal2 {

	public static void main(String[] args) {
		Node root = initializeTree();

		List<List<Integer>> result = levelOrderTraversal(root);

		System.out.println("List after Level order traversal:-> " + result);
	}

	private static List<List<Integer>> levelOrderTraversal(Node root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		LinkedList<Node> nodeQueue = new LinkedList<>();
		LinkedList<Integer> levelQueue = new LinkedList<>();

		nodeQueue.offer(root);
		levelQueue.offer(1);// start from 1

		while (!nodeQueue.isEmpty()) {
			Node node = nodeQueue.poll();
			int level = levelQueue.poll();

			List<Integer> l = null;
			if (result.size() < level) {
				l = new ArrayList<>();
				result.add(l);
			} else {
				l = result.get(level - 1);
			}

			l.add(node.val);

			if (node.left != null) {
				nodeQueue.offer(node.left);
				levelQueue.offer(level + 1);
			}

			if (node.right != null) {
				nodeQueue.offer(node.right);
				levelQueue.offer(level + 1);
			}
		}

		return result;
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
