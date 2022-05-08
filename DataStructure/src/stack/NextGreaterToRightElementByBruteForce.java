package stack;

public class NextGreaterToRightElementByBruteForce {

	public static void main(String[] args) {
		int arr[] = { 11, 13, 21, 3 };
		getNextGreaterToRight(arr);
	}

	public static void getNextGreaterToRight(int[] arr) {
		int nextGreater = -1;

		for (int i = 0; i < arr.length; i++) {
			nextGreater = -1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					nextGreater = arr[j];
					break;
				}
			}
			System.out.println(arr[i] + " -- " + nextGreater);
		}
	}
}
