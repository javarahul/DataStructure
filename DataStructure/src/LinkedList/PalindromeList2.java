package LinkedList;

import java.util.Scanner;

/*We can use a fast and slow pointer to get the center of the list, 
 * then reverse the second list and compare two sublists.
 * The time is O(n) and space is O(1).*/

public class PalindromeList2 {
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
		if (head == null || head.next == null) {
			return true;
		}

		Node fast = head;
		Node slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		Node secListHead = slow.next;
		slow.next = null;

		Node p1 = secListHead;
		Node p2 = p1.next;

		while (p1 != null && p2 != null) {
			Node temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}

		secListHead.next = null;
		// System.out.println("Second Reversed list is:-> " + p1);
		// printList(p1);
		// compare two sublists now
		Node p = (p2 == null ? p1 : p2);
		Node q = head;
		while (p != null) {
			if (p.item != q.item)
				return false;

			p = p.next;
			q = q.next;

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
