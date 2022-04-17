package binarysearch;

public class FindElementPosInInfiniteSortedArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
		int target = 90;
		int position = findPosition(arr, target);

		if (position > -1) {
			System.out.println("Item found at position:-> " + (position + 1));
		} else {
			System.out.println("Item not available");
		}
	}

	private static int findPosition(int[] arr, int target) {
		int start = 0;
		int end = 1;

		while (arr[end] < target) {
			start = end;
			end = end * 2;
		}

		return binarySearch(arr, start, end, target);
	}

	private static int binarySearch(int[] arr, int start, int end, int target) {
		int positon = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (target == arr[mid]) {
				positon = mid;
				return positon;
			}

			if (target > arr[mid]) {
				start = mid + 1;
			} else if (target < arr[mid]) {
				end = mid - 1;
			}

		}
		return positon;
	}
}
