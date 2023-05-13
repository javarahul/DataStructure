package geeksforgeeks.practice.array;

public class IsSortedArray2 {

	public static void main(String[] args) {
		int arr[] = { 5, 20, 25, 50, 100 };
		boolean isSorted = isSorted(arr);
		if (isSorted) {
			System.out.println("Given array is sorted");
		} else {
			System.out.println("Given array is not sorted");
		}
	}

	private static boolean isSorted(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				return false;
			}
		}
		return true;
	}
}
