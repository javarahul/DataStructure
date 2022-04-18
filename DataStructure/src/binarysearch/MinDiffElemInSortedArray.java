package binarysearch;

public class MinDiffElemInSortedArray {

	public static void main(String[] args) {
		int array[] = { 2, 4, 8, 10, 11, 12, 14, 17, 19, 20 };
		int key = 5;

		int element = getMinDiffElement(array, key);

		System.out.println("Min Diff Element:-> " + element);
	}

	private static int getMinDiffElement(int array[], int key) {
		int element = -1;
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (array[mid] == key) {
				element = array[mid];
				return element;
			}

			if (array[mid] > key) {
				end = mid - 1;
			} else if (array[mid] < key) {
				start = mid + 1;
			}
		}

		int diff1 = Math.abs(array[end] - key);
		int diff2 = Math.abs(array[start] - key);

		if (diff1 >= diff2) {
			element = array[start];
		} else {
			element = array[end];
		}

		return element;
	}
}
