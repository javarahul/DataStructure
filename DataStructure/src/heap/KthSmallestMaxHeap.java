package heap;

public class KthSmallestMaxHeap {

	public static void main(String[] args) {
		int arr[] = { 12, 3, 5, 7, 19 };
		int n = arr.length, k = 2;

		KthSmallestMaxHeap kthSmallestMinHeap = new KthSmallestMaxHeap();
		System.out.print("K'th smallest element is " + kthSmallestMinHeap.kthSmallest(arr, n, k));
	}

	int kthSmallest(int arr[], int n, int k) {
		MaxHeap maxHeap = new MaxHeap(arr, n);

		for (int i = k; i < n; i++) {
			if (arr[i] < maxHeap.getMax()) {
				maxHeap.extractMax();
			}
		}

		return maxHeap.getMax();
	}

	class MaxHeap {
		private int size;
		private int[] arr;

		public MaxHeap(int arr[], int n) {
			this.arr = arr;
			size = n;

			for (int i = (n - 1) / 2; i >= 0; i--) {
				maxHeapify(i);
			}
		}

		private int parent(int i) {
			return (i - 1) / 2;
		}

		private int left(int i) {
			return (2 * i) + 1;
		}

		private int right(int i) {
			return (2 * i) + 2;
		}

		private int getMax() {
			return arr[0];
		}

		private int extractMax() {
			if (size == 0) {
				return Integer.MAX_VALUE;
			}

			int root = arr[0];
			if (size > 1) {
				arr[0] = arr[size - 1];
				maxHeapify(0);
			}

			size--;

			return root;
		}

		private void maxHeapify(int i) {
			int largest = i;

			int l = left(i);
			int r = right(i);

			if (l < size && arr[l] > arr[largest]) {
				largest = l;
			}

			if (r < size && arr[r] > arr[largest]) {
				largest = r;
			}

			if (largest != i) {
				int temp = arr[i];
				arr[i] = arr[largest];
				arr[largest] = temp;

				maxHeapify(largest);
			}
		}
	}
}
