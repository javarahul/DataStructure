package geeksforgeeks.practice.array;

public class ReverseArray {

	public static void main(String[] args) {
		int arr[] = { 5, 20, 25, 50, 100 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		reverseArray(arr);
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void reverseArray(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}
	}
}
