package sorting;

public class QuickSort {
	public static void main(String args[]) {
		int[] arr = { 9, 2, 4, 7, 3, 7, 10 };
		int low = 0;
		int high = arr.length - 1;

		System.out.println("Before Sorting");
		for (int i = 0; i <= high; i++) {
			System.out.print(arr[i] + " ");
		}

		quickSort(arr, low, high);

		System.out.println();
		System.out.println("After Sorting");
		for (int i = 0; i <= high; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0) {
			return;
		}

		if (low >= high) {
			return;
		}

		int middle = low + (high - low) / 2;
		int pivote = arr[middle];

		int i = low;
		int j = high;

		while (i <= j) {
			while (arr[i] < pivote) {
				i++;
			}
			while (arr[j] > pivote) {
				j--;
			}
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				i++;
				j--;
			}
		}

		if (j > low) {
			quickSort(arr, low, j);
		}

		if (i < high) {
			quickSort(arr, i, high);
		}
	}
}
