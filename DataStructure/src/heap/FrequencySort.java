package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class FrequencySort {

	public static void main(String[] args) {
		Integer[] arr = { 2, 5, 2, 8, 5, 6, 8, 8 };
		sort(arr);
	}

	public static void sort(Integer arr[]) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(new Comparator<>() {

			@Override
			public int compare(Entry<Integer, Integer> entry1, Entry<Integer, Integer> entry2) {
				return -entry1.getValue().compareTo(entry2.getValue());
			}
		});

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			maxHeap.add(entry);
		}

		while (maxHeap.size() > 0) {
			int freq = maxHeap.peek().getValue();
			int item = maxHeap.peek().getKey();

			for (int i = 0; i < freq; i++) {
				System.out.print(item + " ");
			}

			maxHeap.poll();
		}
	}
}
