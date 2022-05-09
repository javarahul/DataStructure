package stack;

public class NextGreaterToLeftElementByBruteForce {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 2, 4 };
		getNextGreaterToLeft(arr);
	}

	public static void getNextGreaterToLeft(int[] arr) {
		int nextGreater = -1;

		for (int i = 0; i < arr.length; i++) {
			nextGreater = -1;
			for (int j = i -1; j >= 0; j--) {
				if (arr[i] < arr[j]) {
					nextGreater = arr[j];
					break;
				}
			}
			System.out.println(arr[i] + " -- " + nextGreater);
		}
	}
}
