package LinkedList;

import java.util.Scanner;

public class DetectLoop {
	public static void main(String args[]) {
		Node head = initialiseLinkedList();
		//This is for four element if total number of 4 element then run code with below line uncommented
//		head.next.next.next.next = head; 
		System.out.println("Current list is:-> ");
		printList(head);

		boolean isLoop = checkLoop(head);

		if (isLoop) {
			System.out.println("Given list having Loop");
		} else {
			System.out.println("Given list is not having Loop");
		}
	}

	private static boolean checkLoop(Node head) {
		Node slowPointer = head;
		Node fastPointer = head;
		while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer == fastPointer) {
				return true;
			}
		}
		return false;
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
