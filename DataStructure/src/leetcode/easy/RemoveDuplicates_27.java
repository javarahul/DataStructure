public class RemoveDuplicates3 {

	public static void main(String[] args) {
		int arr[] = { 3, 2, 2, 3 };
		int n = arr.length;
		int val = 3;
		n = removeDuplicates(arr, val);

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static int removeDuplicates(int[] arr, int val) {
		int nonRepeatedCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != val) {
				arr[nonRepeatedCount++] = arr[i];
			}
		}
		return nonRepeatedCount;
	}
}
