package LinkedList;

import java.util.LinkedList;

public class StackUsingQueue1 {
	static class Stack {
		private static LinkedList<Integer> q1 = new LinkedList<>();
		private static LinkedList<Integer> q2 = new LinkedList<>();
		private static int size;

		public Stack() {
			size = 0;
		}

		public static void push(int newItem) {
			size++;
			q2.add(newItem);

			while (!q1.isEmpty()) {
				q2.add(q1.peek());
				q1.remove();
			}

			LinkedList<Integer> q = q1;
			q1 = q2;
			q2 = q;
		}

		public static void pop() {
			if (q1.isEmpty()) {
				return;
			}
			q1.remove();
			size--;
		}

		public static int top() {
			if (q1.isEmpty()) {
				return -1;
			}
			return q1.peek();
		}

		public static int size() {
			return size;
		}
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);

		System.out.println("current size: " + s.size());
		System.out.println(s.top());
		s.pop();
		System.out.println(s.top());
		s.pop();
		System.out.println(s.top());

		System.out.println("current size: " + s.size());
	}
}
