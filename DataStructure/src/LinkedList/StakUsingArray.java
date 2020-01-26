package LinkedList;

import javax.naming.spi.DirStateFactory.Result;

public class StakUsingArray<E> {
	private E arr[] = null;
	private int CAP;
	private int top = -1;
	private int size = 0;

	public StakUsingArray(int cap) {
		CAP = cap;
		arr = (E[]) new Object[cap];
	}

	public E pop() {
		if (size == 0) {
			return null;
		}
		size--;
		E result = arr[top];
		arr[top] = null;
		top--;

		return result;
	}

	public boolean push(E e) {
		if (isFull()) {
			return false;
		}

		size++;
		arr[++top] = e;

		return true;
	}

	private boolean isFull() {
		if (size == CAP) {
			return true;
		}
		return false;
	}

	public String toString() {
		if (size == 0) {
			return null;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < size; i++) {
			sb.append(arr[i] + ", ");
		}

		sb.setLength(sb.length() - 2);

		return sb.toString();
	}

	public static void main(String[] args) {
		StakUsingArray<String> stack = new StakUsingArray<String>(11);
		stack.push("hello");
		stack.push("world");

		System.out.println(stack);

		stack.pop();
		System.out.println(stack);

		stack.pop();
		System.out.println(stack);
	}
}
