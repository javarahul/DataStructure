package geeksforgeeks.practice.array;

public class MoveZeroesToEnd2 {

	public static void main(String[] args) {
		int arr[] = { 10, 0, 20, 0, 0, 30, 40 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		moveZeroesToEnd(arr);
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void moveZeroesToEnd(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[count];
				arr[count] = temp;
				count++;
			}
		}
	}

}
