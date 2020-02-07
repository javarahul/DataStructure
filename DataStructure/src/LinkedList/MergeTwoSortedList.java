package LinkedList;

import java.util.Scanner;

public class MergeTwoSortedList {
	public static void main(String[] args) {
		Node firstList = initialiseLinkedList();

		System.out.println("First list is:-> ");
		printList(firstList);

		Node secList = initialiseLinkedList();

		System.out.println("Second list is:-> ");
		printList(secList);

		Node head = mergeTwoList(firstList, secList);

		System.out.println("Merged list is:-> ");
		printList(head);
	}

	private static Node mergeTwoList(Node firstList, Node secList) {
		Node combinedList = new Node(0);
		Node p = combinedList;
		Node p1 = firstList;
		Node p2 = secList;

		while (p1 != null && p2 != null) {
			if (p1.item <= p2.item) {
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
		return combinedList.next;
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
