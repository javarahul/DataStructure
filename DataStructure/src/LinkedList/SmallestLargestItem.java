package LinkedList;

import java.util.Scanner;

public class SmallestLargestItem {

	public static void main(String[] args) {
		Node head = initialiseLinkedList();

		System.out.println("Current list is:-> ");
		printList(head);

		int smallest = findSmallest(head);
		int largest = findLargest(head);

		System.out.println("Smallest item is:-> " + smallest);
		System.out.println("Largest item is:-> " + largest);
	}

	private static int findLargest(Node head) {
		if (head == null) {
			return Integer.MIN_VALUE;
		}
		Node curr = head;
		int max = Integer.MIN_VALUE;

		while (curr != null) {
			if (max < curr.item) {
				max = curr.item;
			}
			curr = curr.next;
		}
		return max;
	}

	private static int findSmallest(Node head) {
		if (head == null) {
			return Integer.MIN_VALUE;
		}
		Node curr = head;
		int min = Integer.MAX_VALUE;

		while (curr != null) {
			if (min > curr.item) {
				min = curr.item;
			}
			curr = curr.next;
		}
		return min;
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
