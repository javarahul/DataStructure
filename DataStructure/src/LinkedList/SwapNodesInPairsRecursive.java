package LinkedList;

import java.util.Scanner;

public class SwapNodesInPairsRecursive {

	public static void main(String[] args) {
		Node head = initialiseLinkedList();

		System.out.println("Current list is:-> ");
		printList(head);

		head = swapNode(head);

		System.out.println("List after Node Swap is:-> ");
		printList(head);

	}

	private static Node swapNode(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node remaining = head.next.next;

		Node updatedHead = head.next;
		head.next.next = head;

		head.next = swapNode(remaining);
		return updatedHead;
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
