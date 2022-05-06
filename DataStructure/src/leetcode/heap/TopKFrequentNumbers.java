package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentNumbers {

	public static void main(String[] args) {
		int arr[] = { 3, 1, 4, 4, 5, 2, 6, 1 };
		int k = 2;

		printKMostFrequentNumber(arr, k);
	}

	private static void printKMostFrequentNumber(int arr[], int k) {
		HashMap<Integer, Integer> frequncyMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			frequncyMap.put(arr[i], frequncyMap.getOrDefault(arr[i], 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> minHeap1 = new PriorityQueue<>(new Comparator<>() {
			@Override
			public int compare(Entry<Integer, Integer> a, Entry<Integer, Integer> b) {
				// Can keep this line only return Integer.compare(b.getValue(), a.getValue());
				if (a.getValue().equals(b.getValue())) {
					return Integer.compare(a.getKey(), b.getKey());
				} else {
					return Integer.compare(a.getValue(), b.getValue());
				}
			}
		});

		for (Entry<Integer, Integer> entry : frequncyMap.entrySet()) {
			minHeap1.add(entry);
			if (minHeap1.size() > k) {
				minHeap1.poll();
			}
		}
		for (int i = 0; i < k; i++) {
			System.out.println(minHeap1.poll().getKey());
		}
	}
}
