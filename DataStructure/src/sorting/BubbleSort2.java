package sorting;

public class BubbleSort2 {

	public static void main(String[] args) {
		int[] arr = { 9, 2, 4, 7, 3, 7, 10 };

		System.out.println("Before Sorting");
		print(arr);

		bubbleSort(arr);

		System.out.println();
		System.out.println("After Sorting");
		print(arr);

	}

	private static void bubbleSort(int[] arr) {
		int n = arr.length;
		boolean swapped;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}

	private static void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
