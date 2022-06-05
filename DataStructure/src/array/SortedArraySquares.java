package array;

public class SortedArraySquares {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 3, 4 };

		doSquares(arr);
		for (int arrItem : arr) {
			System.out.print(arrItem + " ");
		}

		System.out.println();
		mergeSort(arr, 0, arr.length - 1);

		for (int arrItem : arr) {
			System.out.print(arrItem + " ");
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

	private static void doSquares(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * arr[i];
		}
	}
}
