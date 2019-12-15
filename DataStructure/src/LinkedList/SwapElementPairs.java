package LinkedList;

import java.util.Scanner;

public class SwapElementPairs {

	public static void main(String[] args) {
		Node head = initialiseLinkedList();

		System.out.println("Current list is:-> ");
		printList(head);

		head = swapElement(head);

		System.out.println("List after Swap Elements in pairs is:-> ");
		printList(head);
	}

	private static Node swapElement(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node ptr = head;

		while (ptr != null && ptr.next != null) {
			int temp = ptr.item;
			ptr.item=ptr.next.item;
			ptr.next.item=temp;
			ptr=ptr.next.next;
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
