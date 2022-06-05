package array;

public class SortedArraySquares2 {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 3, 4 };

		System.out.println("Before Sorting:-> ");
		printArrayItem(arr);

		int squares[] = doSquaresWithSorting(arr);

		System.out.println();
		System.out.println("After Sorting:-> ");
		printArrayItem(squares);
	}

	private static int[] doSquaresWithSorting(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int index = 0;
		int squares[] = new int[arr.length];

		while (left <= right) {
			int leftSquare = arr[left] * arr[left];
			int rightSquare = arr[right] * arr[right];

			if (leftSquare <= rightSquare) {
				squares[index] = leftSquare;
				left++;
			} else {
				squares[index] = rightSquare;
				right--;
			}
			index++;
		}
		return squares;
	}

	private static void printArrayItem(int arr[]) {
		for (int arrItem : arr) {
			System.out.print(arrItem + " ");
		}
	}
}
