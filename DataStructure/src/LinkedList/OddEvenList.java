package LinkedList;

import java.util.Scanner;

public class OddEvenList {
	public static void main(String[] args) {
		Node head = initialiseLinkedList();

		System.out.println("Current list is:-> ");
		printList(head);

		Node result = oddEvenList(head);
		System.out.println("Odd Even list is:-> ");
		printList(result);
	}

	private static Node oddEvenList(Node head) {
		if (head == null) {
			return head;
		}

		Node result = head;
		Node ptr1 = head;
		Node ptr2 = head.next;
		Node headNext = head.next;

		while (ptr1 != null && ptr2 != null) {
			Node temp = ptr2.next;
			if (temp == null) {
				break;
			}

			ptr1.next = ptr2.next;
			ptr1 = ptr1.next;

			ptr2.next = ptr1.next;
			ptr2 = ptr2.next;
		}
		ptr1.next=headNext;
		return result;
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
