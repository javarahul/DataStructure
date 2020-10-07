package tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class SerializeDesesrilizeTree1 {

	public static void main(String[] args) {
		SerializeDesesrilizeTree1 tree = new SerializeDesesrilizeTree1();
		Node root = tree.initalizeTree();

		System.out.print("Tree is in inOrder:-> ");
		tree.inOrder(root);
		System.out.println();

		String treeInString = tree.Serialize(root);
		System.out.println("Serialized the tree and store in String as given:-> " + treeInString);

		System.out.println("Now going for deserialize");
		Node root1 = tree.DeSerialize(treeInString);

		System.out.print("Tree is in inOrder after DeSeriliation:-> ");
		tree.inOrder(root1);
		System.out.println();
	}

	private Node DeSerialize(String treeInString) {
		String str[] = treeInString.split(",");
		if (str[0].equals("#")) {
			return null;
		}

		Node tree = new Node(Integer.parseInt(str[0]));
		LinkedList<Node> queue = new LinkedList<>();
		queue.offer(tree);

		int i = 1;

		while (!queue.isEmpty()) {
			Node head = queue.poll();
			if (head != null) {
				Node left = null;
				if (!str[i].equals("#")) {
					left = new Node(Integer.parseInt(str[i]));
				}
				head.left = left;
				queue.offer(left);
				i++;

				Node right = null;
				if (!str[i].equals("#")) {
					right = new Node(Integer.parseInt(str[i]));
				}
				head.right = right;
				queue.offer(right);
				i++;
			}
		}

		return tree;
	}

	private String Serialize(Node root) {
		ArrayList<String> list = new ArrayList<>();
		LinkedList<Node> queue = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			Node head = queue.poll();

			if (head == null) {
				list.add("#");
			} else {
				list.add("" + head.val);
				queue.offer(head.left);
				queue.offer(head.right);
			}
		}
		return String.join(",", list);
	}

	private void inOrder(Node root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(" " + root.val);
		inOrder(root.right);
	}

	private Node initalizeTree() {
		Node root = new Node(6);
		root.left = new Node(2);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.right = new Node(12);
		root.right.left = new Node(7);

		return root;
	}
}
