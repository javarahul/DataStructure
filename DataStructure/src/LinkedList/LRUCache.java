package LinkedList;

import java.util.HashMap;

class LRUCache {
	private static DoublyNode head;
	private DoublyNode tail;
	private HashMap<Integer, DoublyNode> map = null;
	private int cap = 0;

	public LRUCache(int capacity) {
		cap = capacity;
		map = new HashMap<>();
	}

	public int get(int key) {
		if (map.get(key) == null) {
			return -1;
		}

		// move to tail
		DoublyNode t = map.get(key);

		removeDoublyNode(t);
		offerDoublyNode(t);

		return t.value;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			DoublyNode t = map.get(key);
			t.value = value;

			// move to tail
			removeDoublyNode(t);
			offerDoublyNode(t);
		} else {
			if (map.size() >= cap) {
				// delete head
				map.remove(head.key);
				removeDoublyNode(head);
			}

			// add to tail
			DoublyNode DoublyNode = new DoublyNode(key, value);
			offerDoublyNode(DoublyNode);
			map.put(key, DoublyNode);
		}
	}

	private void removeDoublyNode(DoublyNode n) {
		if (n.prev != null) {
			n.prev.next = n.next;
		} else {
			head = n.next;
		}

		if (n.next != null) {
			n.next.prev = n.prev;
		} else {
			tail = n.prev;
		}
	}

	private void offerDoublyNode(DoublyNode n) {
		if (tail != null) {
			tail.next = n;
		}

		n.prev = tail;
		n.next = null;
		tail = n;

		if (head == null) {
			head = tail;
		}
	}

	private void printList(DoublyNode head) {
		DoublyNode curr = head;
		while (curr != null) {
			System.out.print(curr.value + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		LRUCache lr = new LRUCache(5);
		lr.put(1, 1);

		lr.put(2, 2);

		lr.put(3, 3);

		lr.put(4, 4);

		lr.put(5, 5);

		int val = lr.get(1);

		System.out.println("" + val);

		lr.put(6, 6);

		int val2 = lr.get(2);

		System.out.println("" + val2);
	}
}