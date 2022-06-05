package array;

public class SortedArraySquares1 {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 3, 4 };

		System.out.println("Before Sorting:-> ");
		printArrayItem(arr);

		doSquaresWithSorting(arr);

		System.out.println();
		System.out.println("After Sorting:-> ");
		printArrayItem(arr);
	}

	private static void doSquaresWithSorting(int[] arr) {
		int k = 0;

		for (k = 0; k < arr.length; k++) {
			if (arr[k] >= 0) {
				break;
			}
		}

		int i = k - 1;
		int j = k;

		int currIndex = 0;

		int temp[] = new int[arr.length];

		while (i >= 0 && j < arr.length) {
			if (arr[i] * arr[i] <= arr[j] * arr[j]) {
				temp[currIndex] = arr[i] * arr[i];
				i--;
			} else {
				temp[currIndex] = arr[j] * arr[j];
				j++;
			}
			currIndex++;
		}

		while (i >= 0) {
			temp[currIndex++] = arr[i] * arr[i];
			i--;
		}

		while (j < arr.length) {
			temp[currIndex++] = arr[j] * arr[j];
			j++;
		}
		currIndex = 0;
		for (int l : temp) {
			arr[currIndex++] = l;
		}
	}

	private static void printArrayItem(int arr[]) {
		for (int arrItem : arr) {
			System.out.print(arrItem + " ");
		}
	}
}
