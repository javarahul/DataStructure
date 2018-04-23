package LinkedList;

import java.util.Scanner;

public class RecursiveReverseLinkedList {
	public static void main(String args[]) {
		Node head = initialiseLinkedList();

		System.out.println("Current list is:-> ");
		printList(head);

		head = reverseList(head);

		System.out.println("Reversed list is:-> ");
		printList(head);
	}

	private static Node reverseList(Node head) {
		if (head == null || head.next == null){
			return head;
		}

		Node nextOfHead = head.next;
		head.next = null;

		Node rest = reverseList(nextOfHead);
		nextOfHead.next = head;

		return rest;
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
