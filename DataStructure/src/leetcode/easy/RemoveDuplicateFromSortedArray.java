package leetcode.easy;

public class RemoveDuplicateFromSortedArray {

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

		int i = 1;
		int j = 0;

		while (i < arr.length) {
			if (arr[i] != arr[j]) {
				j++;
				arr[j] = arr[i];
			}
			i++;
		}
		return j + 1;
	}
}
