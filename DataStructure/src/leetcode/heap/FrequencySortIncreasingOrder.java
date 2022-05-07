package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class FrequencySortIncreasingOrder {

	public static void main(String[] args) {
		Integer[] arr = { -1, 1, -6, 4, 5, -6, 1, 4, 1 };
		sort(arr);
	}

	public static void sort(Integer arr[]) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(new Comparator<>() {

			@Override
			public int compare(Entry<Integer, Integer> entry1, Entry<Integer, Integer> entry2) {
				if (entry1.getValue().equals(entry2.getValue())) {
					return Integer.compare(entry2.getKey(), entry1.getKey());
				} else {
					return Integer.compare(entry1.getValue(), entry2.getValue());
				}
			}
		});

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			minHeap.add(entry);
		}

		while (minHeap.size() > 0) {
			int freq = minHeap.peek().getValue();
			int item = minHeap.peek().getKey();

			for (int i = 0; i < freq; i++) {
				System.out.print(item + " ");
			}

			minHeap.poll();
		}
	}
}
