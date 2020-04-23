package tree;

public class SortedListTOBST {
	private static ListCustom head;
	private static ListCustom headForConversion;

	public static void main(String[] args) {
		ListCustom list = initializeList();

		System.out.println("Given List:-> ");
		list.print(head);
		System.out.println();

		System.out.println("Inorder Traversal of the BST:-> ");

		Node root = sortedListToBST(head);

		System.out.println("After converstion Tree");
		printInPreOrder(root);
	}

	private static void printInPreOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		printInPreOrder(root.left);
		printInPreOrder(root.right);
	}

	private static Node sortedListToBST(ListCustom head) {
		if (head == null) {
			return null;
		}
		headForConversion = head;

		int lenghtOfList = getLength(head);

		return sortedListToBST(0, lenghtOfList - 1);
	}

	private static Node sortedListToBST(int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;

		Node left = sortedListToBST(start, mid - 1);

		Node root = new Node(headForConversion.val);
		headForConversion = headForConversion.next;

		Node right = sortedListToBST(mid + 1, end);

		root.left = left;
		root.right = right;

		return root;
	}

	private static int getLength(ListCustom head) {
		int len = 0;
		ListCustom ptr = head;

		while (ptr != null) {
			len++;
			ptr = ptr.next;
		}
		return len;
	}

	private static ListCustom initializeList() {
		ListCustom list = new SortedListTOBST.ListCustom();
		list.push(7);
		list.push(6);
		list.push(5);
		list.push(4);
		list.push(3);
		list.push(2);
		list.push(1);

		return list;
	}

	static class ListCustom {
		int val;
		ListCustom next;

		public ListCustom() {
		}

		public ListCustom(int x) {
			val = x;
			next = null;
		}

		public void push(int item) {
			ListCustom newNode = new ListCustom(item);
			newNode.next = head;
			head = newNode;
		}

		public void print(ListCustom list) {
			while (list != null) {
				System.out.print(list.val + " ");
				list = list.next;
			}
		}
	}
}
