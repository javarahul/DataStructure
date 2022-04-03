package binarysearch;

import java.util.Scanner;

public class BinarySearchFirstAndLastOccurence {

	public static void main(String[] args) {
		int array[] = { 2, 4, 10, 10, 10, 10, 14, 17, 19, 20 };
		System.out.println("Eanter a number which you want to search:-> ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int first = binarySearchFirst(array, num);
		int last = binarySearchLast(array, num);

		System.out.println(num + " present in first occurrence index:-> " + first);

		System.out.println(num + " present in last occurrence index:-> " + last);
	}

	private static int binarySearchFirst(int[] array, int num) {
		int start = 0;
		int end = array.length - 1;
		int result = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (num < array[mid]) {
				end = mid - 1;
			} else if (num > array[mid]) {
				start = mid + 1;
			} else if (num == array[mid]) {
				result = mid;
				end = mid - 1;
			}
		}
		return result;
	}

	private static int binarySearchLast(int[] array, int num) {
		int start = 0;
		int end = array.length - 1;
		int result = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (num < array[mid]) {
				end = mid - 1;
			} else if (num > array[mid]) {
				start = mid + 1;
			} else if (num == array[mid]) {
				result = mid;
				start = mid + 1;
			}
		}
		return result;
	}
}
