package LinkedList;

import java.util.Scanner;

public class SwapNodesInPairs1 {
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

		Node dummy = new Node(0);
		dummy.next = head;
		Node p1 = head;
		Node p2 = head.next;

		Node pre = dummy;

		while (p1 != null && p2 != null) {
			pre.next = p2;
			Node temp = p2.next;
			p2.next = p1;
			pre = p1;
			p1.next = temp;
			p1 = p1.next;

			if (temp != null) {
				p2 = temp.next;
			}
		}
		return dummy.next;
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
