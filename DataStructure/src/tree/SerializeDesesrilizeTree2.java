package tree;

import java.util.Stack;

public class SerializeDesesrilizeTree2 {

	public static void main(String[] args) {
		SerializeDesesrilizeTree2 tree = new SerializeDesesrilizeTree2();
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
		if (treeInString == null) {
			return null;
		}

		int t[] = { 0 };
		String[] str = treeInString.split(",");
		return DeSerialize(str, t);
	}

	private Node DeSerialize(String[] str, int[] counter) {
		if (str[counter[0]].equals("#")) {
			return null;
		}
		Node root = new Node(Integer.parseInt(str[counter[0]]));

		counter[0] = counter[0] + 1;
		root.left = DeSerialize(str, counter);

		counter[0] = counter[0] + 1;
		root.right = DeSerialize(str, counter);

		return root;
	}

	private String Serialize(Node root) {
		if (root == null) {
			return null;
		}

		Stack<Node> stack = new Stack<>();
		stack.push(root);

		StringBuilder sb = new StringBuilder();

		while (!stack.isEmpty()) {
			Node top = stack.pop();

			if (top != null) {
				sb.append(top.val + ",");
				stack.push(top.right);
				stack.push(top.left);
			} else {
				sb.append("#,");
			}
		}

		return sb.toString().substring(0, sb.length() - 1);
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
