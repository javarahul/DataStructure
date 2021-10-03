package leetcode.easy;

import java.util.Scanner;

import LinkedList.Node;

public class MergeTwoList {

	public static void main(String[] args) {
		ListNode firstList = initialiseLinkedList();

		System.out.println("First list is:-> ");
		printList(firstList);

		ListNode secList = initialiseLinkedList();

		System.out.println("Second list is:-> ");
		printList(secList);

		ListNode head = mergeTwoList(firstList, secList);

		System.out.println("Merged list is:-> ");
		printList(head);
	}

	private static ListNode mergeTwoList(ListNode firstList, ListNode secList) {
		ListNode combinedList = new ListNode(0);
		ListNode p = combinedList;
		ListNode p1 = firstList;
		ListNode p2 = secList;

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

	private static ListNode initialiseLinkedList() {
		System.out.println("Enter number count for LinkedList:-> ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Enter numbers:-> ");
		int num = sc.nextInt();
		ListNode head = new ListNode(num);
		ListNode curr = head;
		for (int i = 0; i < n - 1; i++) {
			num = sc.nextInt();
			head.next = new ListNode(num);
			head = head.next;
		}
		return curr;
	}

	private static void printList(ListNode head) {
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.item + " ");
			curr = curr.next;
		}
		System.out.println();
	}
}
