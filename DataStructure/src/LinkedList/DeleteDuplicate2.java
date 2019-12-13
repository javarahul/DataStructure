package LinkedList;

import java.util.Scanner;

public class DeleteDuplicate2 {

	public static void main(String[] args) {
		Node head = initialiseLinkedList();

		System.out.println("Current list is:-> ");
		printList(head);

		head = removeDuplicate(head);

		System.out.println("List after remove duplicate item is:-> ");
		printList(head);
	}

	private static Node removeDuplicate(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node ptr = head;

		while (ptr != null && ptr.next != null) {
			if (ptr.item == ptr.next.item) {
				ptr.next = ptr.next.next;
			} else {
				ptr = ptr.next;
			}
		}
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
