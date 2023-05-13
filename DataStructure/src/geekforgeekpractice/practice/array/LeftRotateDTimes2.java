package geeksforgeeks.practice.array;

public class LeftRotateDTimes2 {

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
		int temp[] = new int[d];
		for (int i = 0; i < d; i++) {
			temp[i] = arr[i];
		}

		for (int i = d; i < arr.length; i++) {
			arr[i - d] = arr[i];
		}

		for (int i = 0; i < d; i++) {
			arr[arr.length - d + i] = temp[i];
		}
	}
}
