package LinkedList;

import java.util.Scanner;

public class SwapNodes {

	public static void main(String[] args) {
		Node head = initialiseLinkedList();

		System.out.println("Current list is:-> ");
		printList(head);

		System.out.println("Enter first element:-> ");
		Scanner sc = new Scanner(System.in);
		int first = sc.nextInt();

		System.out.println("Enter second element:-> ");
		int second = sc.nextInt();

		head = swapNode(head, first, second);

		System.out.println("List after Node Swap is:-> ");
		printList(head);
	}

	private static Node swapNode(Node head, int first, int second) {
		if (head == null || head.next == null || first == second) {
			return head;
		}

		Node prevFirst = null, prevSec = null;
		Node currFirst = head, currSec = head;

		while (currFirst != null && currFirst.item != first) {
			prevFirst = currFirst;
			currFirst = currFirst.next;
		}

		while (currSec != null && currSec.item != second) {
			prevSec = currSec;
			currSec = currSec.next;
		}

		if (currFirst == null || currSec == null) {
			return head;
		}

		if (prevFirst != null) {
			prevFirst.next = currSec;
		} else {
			head = currSec;
		}

		if (prevSec != null) {
			prevSec.next = currFirst;
		} else {
			head = currFirst;
		}

		Node tempNode = currFirst.next;
		currFirst.next = currSec.next;
		currSec.next = tempNode;
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
