package geeksforgeeks.practice.array;

public class SearchOperation {

	public static void main(String[] args) {
		int arr[] = { 20, 5, 7, 25 };
		int x = 5; //15;

		int index = search(arr, x);
		if (index > -1) {
			System.out.println("Item " + x + " found at index " + index);
		} else {
			System.out.println("Item " + x + " is not available");
		}
	}

	private static int search(int[] arr, int x) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				return i;
			}
		}
		return -1;
	}

}
