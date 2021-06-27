package heap;

public class HeapSort {

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Array Before Sorting:-> ");
		printArray(arr);

		HeapSort heapSort = new HeapSort();
		heapSort.sort(arr);

		System.out.println("Array after Heap Sort:-> ");
		printArray(arr);
	}

	private void sort(int arr[]) {
		int n = arr.length;

		for (int i = ((n / 2) - 1); i >= 0; i--) {
			heapify(arr, n, i);
		}

		for (int i = n - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr, i, 0);
		}
	}

	private int left(int i) {
		return 2 * i + 1;
	}

	private int right(int i) {
		return 2 * i + 2;
	}

	private void heapify(int arr[], int size, int index) {
		int largest = index;

		int l = left(index);
		int r = right(index);

		if (l < size && arr[l] > arr[largest]) {
			largest = l;
		}

		if (r < size && arr[r] > arr[largest]) {
			largest = r;
		}

		if (largest != index) {
			int temp = arr[index];
			arr[index] = arr[largest];
			arr[largest] = temp;

			heapify(arr, size, largest);
		}
	}

	private static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i] + " ");
		}
		System.out.println();
	}

}
