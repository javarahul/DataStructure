package heap;

public class AlmostSorted {
	public static void main(String[] args) {
		int k = 3;
		int arr[] = { 2, 6, 3, 12, 56, 8 };
		int n = arr.length;

		AlmostSorted almostSorted = new AlmostSorted();
		almostSorted.kSort(arr, n, k);

		System.out.println("Following is sorted array");
		almostSorted.printArray(arr, n);
	}

	private void kSort(int[] arr, int n, int k) {
		int larr[] = new int[k + 1];
		for (int i = 0; i <= k; i++) {
			larr[i] = arr[i];
		}
		MinHeap mh = new MinHeap(larr, k + 1);

		for (int i = k + 1, ti = 0; ti < n; i++, ti++) {
			if (i < n) {
				arr[ti] = mh.replaceMin(arr[i]);
			} else {
				arr[ti] = mh.extractMin();
			}
		}
	}

	private void printArray(int[] arr, int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	class MinHeap {
		private int size;
		private int[] arr;

		public MinHeap(int arr[], int size) {
			this.arr = arr;
			this.size = size;

			for (int i = (size - 1) / 2; i >= 0; i--) {
				minHeapify(i);
			}
		}

		private int left(int i) {
			return 2 * i + 1;
		}

		private int right(int i) {
			return 2 * i + 2;
		}

		private int replaceMin(int i) {
			int root = arr[0];
			arr[0] = i;
			if (root < i) {
				minHeapify(0);
			}
			return root;
		}

		private int extractMin() {
			int root = arr[0];

			if (size > 1) {
				arr[0] = arr[size - 1];
				size--;
				minHeapify(0);
			}

			return root;
		}

		private void minHeapify(int i) {
			int smallest = i;
			int l = left(i);
			int r = right(i);

			if (l < size && arr[l] < arr[i]) {
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
