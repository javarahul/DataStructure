package sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 9, 2, 4, 7, 3, 7, 10 };

		System.out.println("Before Sorting");
		print(arr);

		selectionSort(arr);

		System.out.println();
		System.out.println("After Sorting");
		print(arr);
	}

	private static void selectionSort(int[] arr) {
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}

			int temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = temp;
		}
	}

	private static void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
