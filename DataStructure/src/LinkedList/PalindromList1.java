package LinkedList;

import java.util.Scanner;

public class PalindromList1 {
	public static void main(String args[]) {
		Node head = initialiseLinkedList();

		System.out.println("Current list is:-> ");
		printList(head);

		boolean isPalindrom = checkPalindrom(head);

		if (isPalindrom) {
			System.out.println("Given list is Palindrom");
		} else {
			System.out.println("Given list is not Palindrom");
		}
	}

	private static boolean checkPalindrom(Node head) {
		if (head == null) {
			return true;
		}

		Node ptr = head;
		Node curr = new Node(head.item);
		while (ptr.next != null) {
			Node temp = new Node(ptr.next.item);
			temp.next = curr;
			curr = temp;
			ptr = ptr.next;
		}
		// printList(curr);
		Node ptr1 = head;
		Node ptr2 = curr;

		while (ptr1 != null) {
			if (ptr1.item != ptr2.item) {
				return false;
			}
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		return true;
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
