package LinkedList;

import java.util.Scanner;

public class RemoveElements {

	public static void main(String[] args) {
		Node head = initialiseLinkedList();

		System.out.println("Current list is:-> ");
		printList(head);

		System.out.println("Enter element which you want to remove:->");
		Scanner sc = new Scanner(System.in);
		int val = sc.nextInt();

		head = removeElement(head, val);

		System.out.println("List After Removal:-> ");
		printList(head);
	}

	private static Node removeElement(Node head, int val) {
		Node dummy = new Node(0);
		dummy.next = head;
		Node p = dummy;

		while (p.next != null) {
			if (p.next.item == val) {
				Node next = p.next;
				p.next = next.next;
			} else {
				p = p.next;
			}
		}

		return dummy.next;
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
