package binarysearch;

public class CeilInSortedArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 4, 6, 10, 12, 14 };
		int x = 11;
		int index = ceilSearch(arr, x);
		if (index == -1)
			System.out.println("Floor of " + x + " dosen't exist in array ");
		else
			System.out.println("Floor of " + x + " is " + index);
	}

	private static int ceilSearch(int[] arr, int x) {
		int start = 0;
		int end = arr.length - 1;
		int result = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == x) {
				result = x;
				return result;
			} else if (arr[mid] > x) {
				result = arr[mid];
				end = mid - 1;
			} else if (arr[mid] < x) {
				start = mid + 1;
			}
		}
		return result;
	}
}
