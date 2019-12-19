package LinkedList;

import java.util.Scanner;

public class SwapNodesKthFromBeginEnd {

	public static void main(String[] args) {
		Node head = initialiseLinkedList();

		System.out.println("Current list is:-> ");
		printList(head);

		System.out.println("Enter swapped nodes position from begining and end:-> ");
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		head = swapKthNode(head, k);

		System.out.println("List after Node Swap is:-> ");
		printList(head);
	}

	private static Node swapKthNode(Node head, int k) {
		int n = countTotalNodes(head);
		if (n < k || (2 * k - 1 == n)) {
			return head;
		}

		Node first = head;
		Node first_prev = null;

		for (int i = 1; i < k; i++) {
			first_prev = first;
			first = first.next;
		}

		Node sec = head;
		Node sec_prev = null;

		for (int i = 1; i < n - k + 1; i++) {
			sec_prev = sec;
			sec = sec.next;
		}

		if (first_prev != null) {
			first_prev.next = sec;
		}

		if (sec_prev != null) {
			sec_prev.next = first;
		}

		Node temp = first.next;
		first.next = sec.next;
		sec.next = temp;

		if (k == 1) {
			head = sec;
		}

		if (k == n) {
			head = first;
		}
		return head;
	}

	private static int countTotalNodes(Node head) {
		int count = 0;
		Node ptr = head;

		while (ptr != null) {
			count++;
			ptr = ptr.next;
		}
		return count;
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
