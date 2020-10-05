package tree;

public class FindIdenticalTrees {

	public static void main(String[] args) {
		FindIdenticalTrees findIdenticalTrees = new FindIdenticalTrees();
		Node root1 = findIdenticalTrees.initializeFirstTree();
		Node root2 = findIdenticalTrees.initializeSecondTree();

		if (findIdenticalTrees.getIdenticalTrees(root1, root2))
			System.out.println("Both trees are identical");
		else
			System.out.println("Trees are not identical");
	}

	private boolean getIdenticalTrees(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 != null && root2 != null) {
			return (root1.val == root2.val && getIdenticalTrees(root1.left, root2.left)
					&& getIdenticalTrees(root1.right, root2.right));
		}
		return false;
	}

	private Node initializeSecondTree() {
		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);
		return root2;
	}

	private Node initializeFirstTree() {
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);
		return root1;
	}
}
