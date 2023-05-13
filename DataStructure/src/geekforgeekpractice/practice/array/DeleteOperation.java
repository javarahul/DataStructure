package geeksforgeeks.practice.array;

public class DeleteOperation {

	public static void main(String[] args) {
		int arr[] = { 3, 8, 12, 5, 6 };
		int length = arr.length;
		int currTotalElement = length;

		int x = 12;
		for (int item : arr) {
			System.out.print(item + " ");
		}
		System.out.println();
		currTotalElement = deleteElement(arr, length, currTotalElement, x);
		if (currTotalElement > -1) {
			System.out.println("Given element " + x + " found and deleted");
			System.out.println("Now total element avalable in array: " + currTotalElement);
			for (int item : arr) {
				System.out.print(item + " ");
			}
		}
	}

	private static int deleteElement(int[] arr, int length, int currTotalElement, int x) {
		int i = 0;
		for (i = 0; i < length; i++) {
			if (arr[i] == x) {
				break;
			}
		}

		if (i == length) {
			System.out.println("Given element " + x + " not found");
			return -1;
		}
		int j;
		for (j = i; j < length - 1; j++) {
			arr[j] = arr[j + 1];
		}
		arr[j] = -1/*-1 denoting the empty space in array*/;
		return currTotalElement - 1;
	}

}
