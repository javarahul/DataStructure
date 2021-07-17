package heap;

public class KthSmallestMinHeap {

	public static void main(String[] args) {
		int arr[] = { 12, 3, 5, 7, 19 };
		int n = arr.length, k = 2;

		KthSmallestMinHeap kthSmallestMinHeap = new KthSmallestMinHeap();
		System.out.print("K'th smallest element is " + kthSmallestMinHeap.kthSmallest(arr, n, k));
	}

	int kthSmallest(int arr[], int n, int k) {
		MinHeap minHeap = new MinHeap(arr, n);

		for (int i = 0; i < k - 1; i++) {
			minHeap.extractMin();
		}

		return minHeap.getMin();
	}

	class MinHeap {
		private int size;
		private int arr[];

		MinHeap(int arr[], int size) {
			this.size = size;
			this.arr = arr;

			for (int i = (size - 1) / 2; i >= 0; i--) {
				minHeapify(i);
			}
		}

		int getMin() {
			return arr[0];
		}

		private int extractMin() {
			if (size == 0) {
				return Integer.MAX_VALUE;
			}

			int root = arr[0];

			if (size > 1) {
				arr[0] = arr[size - 1];
				minHeapify(0);
			}

			size--;

			return root;
		}

		private void minHeapify(int i) {
			int smallest = i;
			int l = 2 * i + 1;
			int r = 2 * i + 2;

			if (l < size && arr[l] < arr[smallest]) {
				smallest = l;
			}

			if (r < size && arr[r] < arr[smallest]) {
				smallest = r;
			}

			if (smallest != i) {
				int temp = arr[i];
				arr[i] = arr[smallest];
				arr[smallest] = temp;

				minHeapify(smallest);
			}
		}
	}
}
