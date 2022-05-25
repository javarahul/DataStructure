package grokking.twopointerspattern;

public class RemoveDuplicates_26 {

	public static void main(String[] args) {
		int arr[] = { 1,1,2};
		int n = arr.length;

		n = removeDuplicates(arr);

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static int removeDuplicates(int[] arr) {
		int temp[] = new int[arr.length];
		int nonRepeatedCount = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				temp[nonRepeatedCount++] = arr[i];
			}
		}
		temp[nonRepeatedCount++] = arr[arr.length - 1];
		for (int i = 0; i < nonRepeatedCount; i++) {
			arr[i] = temp[i];
		}
		return nonRepeatedCount;
	}
}
