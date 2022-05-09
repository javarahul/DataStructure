package stack;

public class NextSmallerToRightElementByBruteForce {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 2, 10, 8 };
		getNextSmallerToRight(arr);
	}

	public static void getNextSmallerToRight(int[] arr) {
		int nextGreater = -1;

		for (int i = 0; i < arr.length; i++) {
			nextGreater = -1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					nextGreater = arr[j];
					break;
				}
			}
			System.out.println(arr[i] + " -- " + nextGreater);
		}
	}
}
