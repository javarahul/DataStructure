package heap;

import java.util.PriorityQueue;

public class KLargestElement {

	public static void main(String[] args) {
		int arr[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
		int K = 3;
		kLargest(arr, K);
	}

	public static void kLargest(int[] arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		for (int i = 0; i < arr.length; i++) {
			minHeap.add(arr[i]);

			if (minHeap.size() > k) {
				minHeap.remove();
			}
		}

		while (minHeap.size() > 0) {
			System.out.println(minHeap.remove());
		}
	}
}
