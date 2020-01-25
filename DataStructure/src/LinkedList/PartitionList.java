package LinkedList;

import java.util.Scanner;

public class PartitionList {

	public static void main(String[] args) {
		Node head = initialiseLinkedList();

		System.out.println("Current list is:-> ");
		printList(head);

		System.out.println("Enter number in which partiton need to do:->");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();

		head = partitionList(head, x);

		System.out.println("List after parition, item is:-> ");
		printList(head);
	}

	private static Node partitionList(Node head, int x) {
		if (head == null) {
			return head;
		}

		Node dummyHead1 = new Node(0);
		Node dummyHead2 = new Node(0);

		dummyHead1.next = head;

		Node curr = head;
		Node prev = dummyHead1;
		Node ptr = dummyHead2;

		while (curr != null) {
			if (curr.item<x){
				curr=curr.next;
				prev = prev.next;
			}else{
				ptr.next=curr;
				prev.next=curr.next;
				
				curr = prev.next;
				ptr = ptr.next;
			}
		}
		
		ptr.next=null;
		prev.next=dummyHead2.next;
		return dummyHead1.next;
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
