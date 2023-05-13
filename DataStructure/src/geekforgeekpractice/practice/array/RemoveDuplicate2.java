package geeksforgeeks.practice.array;

public class RemoveDuplicate2 {

	public static void main(String[] args) {
		int arr[] = { 10, 10, 20, 20, 30, 30, 30 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		int result = removeDiplicate(arr);

		System.out.println("Count of element after removing duplicate items from the array: " + result);

		for (int i = 0; i < result; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static int removeDiplicate(int[] arr) {
		int result = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[result - 1] != arr[i]) {
				arr[result] = arr[i];
				result++;
			}
		}
		return result;
	}
}
