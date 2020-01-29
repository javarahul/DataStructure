package LinkedList;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QueueUsingArray<E> {
	private E[] arr;
	private int head = -1;
	private int tail = -1;
	int size;

	public QueueUsingArray(Class<E> c, int size) {
		E[] newInstance = (E[]) Array.newInstance(c, size);
		arr = newInstance;
		this.size = 0;
	}

	public boolean push(E e) {
		if (size == arr.length) {
			return false;
		}

		head = (head + 1) % arr.length;
		arr[head] = e;
		size++;

		if (tail == -1) {
			tail = head;
		}
		return true;
	}

	public boolean pop() {
		if (size == 0) {
			return false;
		}

		E result = arr[tail];
		arr[tail] = null;
		size--;
		tail = (tail + 1) % arr.length;

		if (size == 0) {
			head = tail = -1;
		}
		return true;
	}

	public E peek() {
		if (size == 0) {
			return null;
		}
		return arr[tail];
	}

	public int size() {
		return size;
	}

	public String toString() {
		return Arrays.toString(arr);
	}

	public static void main(String[] args) {
		QueueUsingArray<Integer> q = new QueueUsingArray<Integer>(Integer.class, 5);
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		q.push(5);
		q.pop();
		q.push(6);
		System.out.println(q);
	}
}
