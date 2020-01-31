package LinkedList;

import java.util.Scanner;

public class RerderList {

	public static void main(String[] args) {
		Node head = initialiseLinkedList();
		System.out.println("Current list is:-> ");
		printList(head);

		reorderList(head);

		printList(head);
	}

	private static void reorderList(Node head) {
		if (head == null || head.next == null) {
			return;
		}

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node secListHead = slow.next;
		slow.next = null;

		secListHead = reverseOrder(secListHead);

		Node p1 = head;
		Node p2 = secListHead;

		while (p2 != null) {
			Node temp1 = p1.next;
			Node temp2 = p2.next;

			p1.next = p2;
			p2.next = temp1;

			p1 = temp1;
			p2 = temp2;
		}
	}

	private static Node reverseOrder(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node pre = null;
		Node curr = head;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}

		// set head node's next
		head.next = null;

		return pre;
	}

	private static Node initialiseLinkedList() {
		System.out.println("Enter number count for LinkedList:-> ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Enter numbers:-> ");
		int num = sc.nextInt();
		Node head = new Node(num);
		Node curr = head;
		for (int i = 0; i < n - 1; i++) {
			num = sc.nextInt();
			head.next = new Node(num);
			head = head.next;
		}
		return curr;
	}

	private static void printList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.item + " ");
			curr = curr.next;
		}
		System.out.println();
	}
}
