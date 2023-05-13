package geeksforgeeks.practice.array;

public class LeftRotateDTimes3 {

	public static void main(String[] args) {
		int arr[] = { 10, 0, 20, 0, 0, 30, 40 };

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		int d = 2;
		leftRotate(arr, d);
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void leftRotate(int arr[], int d) {
		reverseArray(arr, 0, d - 1);
		reverseArray(arr, d, arr.length - 1);
		reverseArray(arr, 0, arr.length - 1);
	}

	private static void reverseArray(int arr[], int low, int high) {
		while (low < high) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}
	}
}
