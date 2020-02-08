package LinkedList;

import java.util.Scanner;

public class MergeKSortedList {

	public static void main(String[] args) {
		System.out.println("Please enter the number of list:-> ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node array[] = new Node[n];
		for (int i = 0; i < n; i++) {
			array[i] = initialiseLinkedList(i + 1);
		}

		System.out.println("Current list is " + n);
		for (int i = 0; i < n; i++) {
			printList(array[i]);
		}

		Node head = mergeKSortedList(array, n - 1);

		System.out.println("Merged list is:-> ");
		printList(head);
	}

	private static Node mergeKSortedList(Node[] array, int last) {
		// repeat until only one list is left
		while (last != 0) {
			int i = 0, j = last;

			// (i, j) forms a pair
			while (i < j) {
				// merge List i with List j and store
				// merged list in List i
				array[i] = SortedMerge(array[i], array[j]);

				// consider next pair
				i++;
				j--;

				// If all pairs are merged, update last
				if (i >= j)
					last = j;
			}
		}

		return array[0];
	}

	private static Node SortedMerge(Node a, Node b) {
		Node result = null;
		/* Base cases */
		if (a == null)
			return b;
		else if (b == null)
			return a;

		/* Pick either a or b, and recur */
		if (a.item <= b.item) {
			result = a;
			result.next = SortedMerge(a.next, b);
		} else {
			result = b;
			result.next = SortedMerge(a, b.next);
		}

		return result;
	}

	private static Node initialiseLinkedList(int currListNum) {
		System.out.println("Enter number count for LinkedList " + currListNum + ":->");
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
