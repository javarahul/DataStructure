package geeksforgeeks.practice.array;

public class MaxDifference1 {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 10, 6, 4, 8, 1 };
		int maxDiff = getMaxDiff(arr);
		System.out.println("Max Diff is: " + maxDiff);
	}

	public static int getMaxDiff(int arr[]) {
		int maxDiff = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int currDiff = arr[j] - arr[i];
				if (maxDiff < currDiff) {
					maxDiff = currDiff;
				}
			}
		}
		return maxDiff;
	}
}
