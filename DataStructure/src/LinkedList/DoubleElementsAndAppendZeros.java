package LinkedList;

import java.util.Scanner;

public class DoubleElementsAndAppendZeros {

	public static void main(String[] args) {
		Node head = initialiseLinkedList();

		System.out.println("Current list is:-> ");
		printList(head);

		head = doubleAndAppend0(head);

		System.out.println("List after Node Swap is:-> ");
		printList(head);
	}

	private static Node doubleAndAppend0(Node head) {
		doubleBefore0(head);
		return append0(head);
	}

	private static Node append0(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}

		Node originalTail = tail;

		Node curr = head;

		while (curr.next != null && curr.item == 0) {
			tail.next = curr;
			tail = curr;
			curr = curr.next;
		}
		head = curr;

		Node prev = curr;
		curr = curr.next;

		while (curr != originalTail) {
			if (curr.item == 0) {
				tail.next = curr;
				tail = curr;
				prev.next = curr.next;
			} else {
				prev = curr;
			}
			curr = curr.next;
		}
		tail.next = null;
		return head;
	}

	private static void doubleBefore0(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}
		if (head.item == head.next.item && head.next.next.item == 0) {
			int temp = head.item;
			head.item = 2 * temp;
			head.next.item = 0;

			if (head.next.next.next != null) {
				head = head.next.next.next;
			} else {
				return;
			}
		} else {
			head = head.next;
		}
		doubleAndAppend0(head);
	}

	private static void printList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.item + " ");
			curr = curr.next;
		}
		System.out.println();
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
}
