package LinkedList;

import java.util.Scanner;

public class RemoveNthNodeFromEnd {
	public static void main(String[] args) {
		Node head = initialiseLinkedList();

		System.out.println("Current list is:-> ");
		printList(head);

		System.out.println("Enter the Nth number from End which we need to remove:->");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();

		Node modifiedList = removeNthNodeFromEnd(head, number);

		System.out.println("List after removing Nth Number node from the end is:-> ");
		printList(modifiedList);
	}

	private static Node removeNthNodeFromEnd(Node head, int number) {
		if (head == null) {
			return null;
		}

		Node ptr = head;
		int len = 0;

		while (ptr != null) {
			len++;
			ptr = ptr.next;
		}

		int fromStart = len - number + 1;
		if (fromStart == 1) {
			return head.next;
		}

		ptr = head;
		int i = 0;

		while (ptr != null) {
			i++;
			if (i == fromStart - 1) {
				ptr.next = ptr.next.next;
			}
			ptr = ptr.next;
		}
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
