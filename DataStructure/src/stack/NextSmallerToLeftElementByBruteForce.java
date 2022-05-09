package stack;

public class NextSmallerToLeftElementByBruteForce {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 2, 10, 8 };
		getNextSmallerToLeft(arr);
	}

	public static void getNextSmallerToLeft(int[] arr) {
		int nextGreater = -1;

		for (int i = 0; i < arr.length; i++) {
			nextGreater = -1;
			for (int j = i -1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					nextGreater = arr[j];
					break;
				}
			}
			System.out.println(arr[i] + " -- " + nextGreater);
		}
	}
}
