package LinkedList;

import java.util.LinkedList;

public class StackUsingQueue2 {

	static class Stack {

		static LinkedList<Integer> queue1 = new LinkedList<>();
		static LinkedList<Integer> queue2 = new LinkedList<>();

		public static void push(int item) {
			if (empty()) {
				queue1.offer(item);
			} else {
				if (queue1.size() > 0) {
					queue2.offer(item);
					int size = queue1.size();
					while (size > 0) {
						queue2.offer(queue1.poll());
						size--;
					}
				} else if (queue2.size() > 0) {
					queue1.offer(item);
					int size = queue2.size();
					while (size > 0) {
						queue1.offer(queue2.poll());
						size--;
					}
				}
			}
		}

		public static void pop() {
			if (queue1.size() > 0) {
				queue1.poll();
			} else if (queue2.size() > 0) {
				queue2.poll();
			}
		}

		public static int top() {
			if (queue1.size() > 0) {
				return queue1.peek();
			} else if (queue2.size() > 0) {
				return queue2.peek();
			}
			return 0;
		}

		public static boolean empty() {
			return queue1.isEmpty() & queue2.isEmpty();
		}
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);

		System.out.println(s.top());
		s.pop();
		System.out.println(s.top());
		s.pop();
		System.out.println(s.top());

	}
}
