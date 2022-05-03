package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestNumbers {

	public static void main(String[] args) {
		int arr[] = {10, 2, 14, 4, 7, 6}; 
		int x = 5, k = 3;
		printKclosest(arr, x, k);
	}

	private static void printKclosest(int arr[], int x, int k) {
		PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>() {

			@Override
			public int compare(Pair p1, Pair p2) {
				// Need to sort in decreasing manner
				int val = p1.getKey().compareTo(p2.getKey());
				if (val > 0) {
					return -1;
				}

				if (val < 0) {
					return 1;
				}

				return 0;

			}
		});

		for (int i = 0; i < arr.length; i++) {
			maxHeap.offer(new KClosestNumbers().new Pair(Math.abs(arr[i] - x), arr[i]));

			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}

		while (maxHeap.size() > 0) {
			System.out.print(maxHeap.poll().getValue() + " ");
		}
	}

	class Pair {
		Integer key;
		Integer value;

		public Pair(Integer key, Integer value) {
			this.key = key;
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}

		public Integer getKey() {
			return key;
		}
	}
}
