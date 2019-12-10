package LinkedList;

import java.util.Scanner;

public class ReverseKGroup {

	public static void main(String[] args) {
		Node head = initialiseLinkedList();

		System.out.println("Current list is:-> ");
		printList(head);

		System.out.println("Enter the group count: ");
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		head = reverseKGroupList(head, k);

		System.out.println("Reversed list is:-> ");
		printList(head);
	}

	private static Node reverseKGroupList(Node head, int k) {
		if (head == null || head.next == null || k == 1) {
			return head;
		}
		
		Node prev = null;
		Node curr = head;
		Node next = null;

		int count = 0;

		while (count < k && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}

		if (next != null) {
			head.next = reverseKGroupList(next, k);
		}

		return prev;
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
