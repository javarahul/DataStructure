package leetcode.easy;

public class RemoveDuplicateFromSortedArray2 {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 3, 4, 4, 4, 5, 5 };
		int n = arr.length;

		n = removeDuplicates(arr);

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static int removeDuplicates(int arr[]) {
		if (arr.length < 2) {
			return arr.length;
		}

		int temp[] = new int[arr.length];
		int j = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				temp[j] = arr[i];
				j++;
			}
		}

		temp[j++] = arr[arr.length - 1];

		for (int i = 0; i < j; i++) {
			arr[i] = temp[i];
		}
		return j;
	}
}
