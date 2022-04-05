package binarysearch;

public class FloorInSortedArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 4, 6, 10, 12, 14 };
		int x = 7;
		int index = floorSearch(arr, x);
		if (index == -1)
			System.out.println("Floor of " + x + " dosen't exist in array ");
		else
			System.out.println("Floor of " + x + " is " + index);
	}

	private static int floorSearch(int[] arr, int x) {
		int start = 0;
		int end = arr.length - 1;
		int result = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == x) {
				result = x;
			} else if (arr[mid] > x) {
				end = mid - 1;
			} else if (arr[mid] < x) {
				result = arr[mid];
				start = mid + 1;
			}
		}
		return result;
	}
}
