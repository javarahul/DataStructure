package LinkedList;

import java.util.Scanner;

public class IntersectionLinkedListItem {
	public static void main(String[] args) {
		Node headOfFirstList = initialiseLinkedList(1);
		Node headOfSecList = initialiseLinkedList(2);

		System.out.println("First list is:-> ");
		printList(headOfFirstList);

		System.out.println("Second list is:-> ");
		printList(headOfSecList);

		Node IntersectionNode = findInterSectionNode(headOfFirstList, headOfSecList);

		System.out.println("InterSection Node Item is:-> " + IntersectionNode.item);
	}

	private static Node findInterSectionNode(Node headOfFirstList, Node headOfSecList) {
		int len1 = 0;
		int len2 = 0;

		Node p1 = headOfFirstList;
		Node p2 = headOfSecList;

		while (p1 != null) {
			len1++;
			p1 = p1.next;
		}

		while (p2 != null) {
			len2++;
			p2 = p2.next;
		}

		int diff = 0;
		p1 = headOfFirstList;
		p2 = headOfSecList;

		if (len1 > len2) {
			diff = len1 - len2;

			for (int i = 0; i < diff; i++) {
				p1 = p1.next;
			}
		} else {
			diff = len2 - len1;

			for (int i = 0; i < diff; i++) {
				p2 = p2.next;
			}

		}

		while (p1 != null && p2 != null) {
			if (p1.item == p2.item) {
				return p1;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		return null;
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
