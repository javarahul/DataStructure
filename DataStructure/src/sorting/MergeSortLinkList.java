package sorting;

import java.util.Scanner;

import LinkedList.Node;

public class MergeSortLinkList {

	public static void main(String[] args) {
		Node head = initialiseLinkedList();

		System.out.println("Current list is:-> ");
		printList(head);

		Node newHead = sortList(head);

		System.out.println("Sorted list is:-> ");
		printList(newHead);
	}

	private static Node sortList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node firstListHead = head;
		Node firstListEnd = getFirstEnd(head);
		Node secListHead = firstListEnd.next;

		firstListEnd.next = null;

		firstListHead = sortList(firstListHead);
		secListHead = sortList(secListHead);

		return merge(firstListHead, secListHead);
	}

	private static Node getFirstEnd(Node head) {
		Node firstPtr = head;
		Node secPtr = head;

		while (firstPtr != null && secPtr.next != null) {
			if (firstPtr.next == null || secPtr.next.next == null) {
				return firstPtr;
			}
			firstPtr = firstPtr.next;
			secPtr = secPtr.next.next;
		}
		return head;
	}

	private static Node merge(Node firstListHead, Node secListHead) {
		Node head = new Node(0);
		Node p = head;
		Node p1 = firstListHead;
		Node p2 = secListHead;

		while (p1 != null && p2 != null) {
			if (p1.item < p2.item) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}
		if (p1 != null) {
			p.next = p1;
		}
		if (p2 != null) {
			p.next = p2;
		}

		return head.next;
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
