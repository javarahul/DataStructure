package LinkedList;

import java.util.Scanner;

public class PlusOneList {
	public static void main(String args[]) {
		Node head = initialiseLinkedList();

		System.out.println("Current list is:-> ");
		printList(head);

		System.out.println("After adding 1, list is:-> ");
		Node newHead = plusOneInExistingList(head);
		printList(newHead);
	}

	private static Node plusOneInExistingList(Node head) {
		Node reverseListHead = reverseList(head);

		Node ptr = reverseListHead;

		while (ptr != null) {
			if (ptr.item + 1 <= 9) {
				ptr.item = ptr.item + 1;
				break;
			} else {
				ptr.item = 0;
				if (ptr.next == null) {
					ptr.next = new Node(1);
					break;
				}
				ptr = ptr.next;
			}
		}

		return reverseList(reverseListHead);
	}

	private static Node reverseList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node prev = null;
		Node curr = head;
		Node next = curr.next;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
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
