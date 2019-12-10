package LinkedList;

import java.util.Random;
import java.util.Scanner;

public class RandomNode {

	public static void main(String[] args) {
		Node head = initialiseLinkedList();

		System.out.println("Current list is:-> ");
		printList(head);

		Random lRandom = new Random();

		int lRandomNodeValue = getRandomNodeValue(head, lRandom);

		System.out.println("Random Node Vaule is:-> " + lRandomNodeValue);
	}

	private static int getRandomNodeValue(Node head, Random lRandom) {
		int count = 1;
		Node ptr = head;
		int result = 0;

		while (ptr != null) {
			if (lRandom.nextInt(count) == 0) {
				result = ptr.item;
			}
			count++;
			ptr = ptr.next;
		}
		return result;
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
