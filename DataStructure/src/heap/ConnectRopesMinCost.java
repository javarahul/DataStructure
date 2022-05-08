package heap;

import java.util.PriorityQueue;

public class ConnectRopesMinCost {

	public static void main(String[] args) {
		int arr[] = { 4, 3, 2, 6 };

		System.out.println("Total cost for connecting ropes is " + minCost(arr));
	}

	private static int minCost(int[] arr) {
		int cost = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int i = 0; i < arr.length; i++) {

			minHeap.add(arr[i]);
		}

		while (minHeap.size() >= 2) {
			int first = minHeap.poll();
			int second = minHeap.poll();

			cost += first + second;

			minHeap.add(first + second);
		}
		return cost;
	}
}
