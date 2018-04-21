package sorting;

public class MergeSort {
	public static void main(String args[]) {
		int[] arr = { 9, 2, 4, 7, 3, 7, 10 };
		int low = 0;
		int high = arr.length - 1;

		System.out.println("Before Sorting");
		for (int i = 0; i <= high; i++) {
			System.out.print(arr[i] + " ");
		}

		mergeSort(arr, low, high);

		System.out.println();
		System.out.println("After Sorting");
		for (int i = 0; i <= high; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void mergeSort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		int middle = low + (high - low) / 2;
		mergeSort(arr, low, middle);
		mergeSort(arr, middle + 1, high);

		merge(arr, low, middle, high);
	}

	private static void merge(int[] arr, int low, int middle, int high) {
		int tempArray[] = new int[arr.length];

		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] = arr[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;

		while (i <= middle && j <= high) {
			if (tempArray[i] <= tempArray[j]) {
				arr[k] = tempArray[i];
				i++;
			} else {
				arr[k] = tempArray[j];
				j++;
			}
			k++;
		}

		while (i <= middle) {
			arr[k++] = tempArray[i++];
		}

		while (j <= high) {
			arr[k++] = tempArray[j++];
		}
	}
}
