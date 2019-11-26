package sorting;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = { 9, 2, 4, 7, 3, 7, 10 };

		System.out.println("Before Sorting");
		print(arr);

		insertionSort(arr);

		System.out.println();
		System.out.println("After Sorting");
		print(arr);
	}

	private static void insertionSort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	private static void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
