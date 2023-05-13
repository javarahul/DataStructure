package geeksforgeeks.practice.array;

public class LeftRotateOnePos {

	public static void main(String[] args) {
		int arr[] = { 10, 0, 20, 0, 0, 30, 40 };

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		leftRotateOnePos(arr);
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void leftRotateOnePos(int[] arr) {
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}
		arr[arr.length - 1] = temp;
	}

}
