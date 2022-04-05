package binarysearch;

import java.util.Scanner;

public class BinarySearchInNearlySortedArray {

	public static void main(String[] args) {
		int arr[] = { 10, 3, 40, 20, 50, 80, 70 };
		System.out.println("Enter item for search:-> ");
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();

		int index = getIndex(arr, key);

		System.out.println("Index:-> " + index);
	}

	private static int getIndex(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (key == arr[mid]) {
				return mid;
			}
			if (mid > start && key == arr[mid - 1]) {
				return mid - 1;
			}
			if (mid < end && key == arr[mid + 1]) {
				return mid + 1;
			}

			if (key < arr[mid]) {
				end = mid - 2;
			}

			if (key > arr[mid]) {
				start = mid + 2;
			}
		}
		return -1;
	}
}
