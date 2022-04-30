package heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestItem {

	class MyComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer val1, Integer val2) {
			int val = val1.compareTo(val2);
			if (val > 0) {
				return -1;
			}

			else if (val < 0) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 5, 4, 3, 48, 15, 6, 2, 33, 53, 10 };
		int K = 4;
		System.out.println("Kth Smallest Element: " + kthSmallest(arr, K));
	}

	public static int kthSmallest(int[] arr, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
				/* Collections.reverseOrder() */ new KthSmallestItem().new MyComparator());

		for (int i = 0; i < arr.length; i++) {
			maxHeap.add(arr[i]);
			if (maxHeap.size() > k) {
				maxHeap.remove();
			}
		}

		return maxHeap.peek();
	}
}
