package geeksforgeeks.practice.array;

public class MoveZeroesToEnd1 {

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
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] != 0) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						break;
					}
				}
			}
		}
	}

}
