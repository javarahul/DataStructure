package LinkedList;

import java.util.Scanner;

public class AddTwoNumbers {

	public static void main(String[] args) {
		System.out.println("Enter the first number:-> ");
		Node firstNumber = getNumbers();

		System.out.println("Enter the second number:-> ");
		Node secNumber = getNumbers();

		System.out.println("First number is:-> ");
		printList(firstNumber);

		System.out.println("Second number is:-> ");
		printList(secNumber);

		Node total = addTwoNumber(firstNumber, secNumber);
		System.out.println("Addition of two numbers are:-> ");
		printList(total);
	}

	private static Node addTwoNumber(Node firstNumber, Node secNumber) {
		firstNumber = getReverse(firstNumber);
		secNumber = getReverse(secNumber);

		Node dummy = new Node(0);
		Node p = dummy;

		Node p1 = firstNumber;
		Node p2 = secNumber;

		int carry = 0;
		while (p1 != null || p2 != null) {
			int sum = carry;
			if (p1 != null) {
				sum += p1.item;
				p1 = p1.next;
			}

			if (p2 != null) {
				sum += p2.item;
				p2 = p2.next;
			}

			if (sum > 9) {
				carry = 1;
				sum = sum - 10;
			} else {
				carry = 0;
			}

			Node l = new Node(sum);
			p.next = l;
			p = p.next;
		}

		if (carry > 0) {
			Node l = new Node(carry);
			p.next = l;
		}
		Node total = dummy.next;

		total = getReverse(total);

		return total;
	}

	private static Node getReverse(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node prev = null;
		Node curr = head;
		Node next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	private static Node getNumbers() {
		System.out.println("Enter the number count:-> ");
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
