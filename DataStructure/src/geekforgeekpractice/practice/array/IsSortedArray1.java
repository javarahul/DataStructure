package geeksforgeeks.practice.array;

public class IsSortedArray1 {

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
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					return false;
				}
			}
		}
		return true;
	}
}
