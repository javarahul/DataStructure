package search;

import java.util.Scanner;

public class BinarySearch {
	public static void main(String args[]) {
		int[] arr = { 2, 3, 4, 7, 7, 9, 10 };
		int low = 0;
		int high = arr.length - 1;

		System.out.println("Enter number which need to be searched:-> ");
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();

		int index = binarySearch(arr, low, high, num);

		if (index == -1) {
			System.out.println("Item not available");
		} else {
			System.out.println("Item available at index:-> " + index);
		}
	}

	private static int binarySearch(int arr[], int low, int high, int num) {
		if (high >= low) {
			int mid = low + (high - low) / 2;

			if ((mid == 0 && arr[mid] == num) || (num > arr[mid - 1] && num == arr[mid])) {
				return mid;
			} else if (num > arr[mid]) {
				return binarySearch(arr, mid + 1, high, num);
			} else {
				return binarySearch(arr, low, mid - 1, num);
			}
		}
		return -1;
	}
}
