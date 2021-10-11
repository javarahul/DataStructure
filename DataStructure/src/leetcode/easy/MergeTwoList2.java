package leetcode.easy;

import java.util.Scanner;

import LinkedList.Node;

public class MergeTwoList2 {

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

	private static ListNode mergeTwoList(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		if (l1.item < l2.item) {
			l1.next = mergeTwoList(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoList(l1, l2.next);
			return l2;
		}

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
