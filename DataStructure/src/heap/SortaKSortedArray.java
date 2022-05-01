package heap;

import java.util.Iterator;
import java.util.PriorityQueue;

public class SortaKSortedArray {

	public static void main(String[] args) {
		int k = 3;
		int arr[] = { 2, 6, 3, 12, 56, 8 };
		System.out.println("Before Sorting array");
		printArray(arr);
		System.out.println();
		int n = arr.length;
		kSort(arr, k);
		System.out.println("Following is sorted array");
		printArray(arr);
	}

	private static void kSort(int[] arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int i = 0; i < k + 1; i++) {
			minHeap.add(arr[i]);
		}

		int index = 0;
		for (int i = k + 1; i < arr.length; i++) {
			arr[index++] = minHeap.poll();
			minHeap.add(arr[i]);
		}

		Iterator<Integer> itr = minHeap.iterator();
		while (itr.hasNext()) {
			arr[index++] = minHeap.poll();
		}
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
