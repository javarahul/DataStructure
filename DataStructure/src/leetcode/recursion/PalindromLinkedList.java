package leatcode.string;

public class PalindromLinkedList {
	static Node left;
	public static void main(String args[]) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(3);
		Node six = new Node(2);
		Node seven = new Node(1);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;
		boolean condition = isPalindrome(one);
		System.out.println("isPalidrome :" + condition);
	}

	public static boolean isPalindrome(Node head) {
		left = head;

		boolean result = helper(head);
		return result;
	}

	public static boolean helper(Node right) {

		if (right == null) {
			return true;
		}
		boolean x = helper(right.next);
		if (!x) {
			return false;
		}
		boolean y = (left.data == right.data);
		left = left.next;
		return y;
	}
}

class Node {
	int data;
	Node next;

	Node(int d) {
		next = null;
		data = d;
	}
}
