package growkking.twopointerspattern;

public class RemoveElementGivenKey {

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
		System.out.println(RemoveElementGivenKey.remove(arr, 3));

		arr = new int[] { 2, 11, 2, 2, 1 };
		System.out.println(RemoveElementGivenKey.remove(arr, 2));
	}

	private static int remove(int arr[], int key) {
		int nextElement = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != key) {
				arr[nextElement] = arr[i];
				nextElement++;
			}
		}
		return nextElement;
	}
}
