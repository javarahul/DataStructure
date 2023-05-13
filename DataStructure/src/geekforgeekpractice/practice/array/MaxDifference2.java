package geeksforgeeks.practice.array;

public class MaxDifference2 {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 10, 6, 4, 8, 1 };
		int maxDiff = getMaxDiff(arr);
		System.out.println("Max Diff is: " + maxDiff);
	}

	public static int getMaxDiff(int arr[]) {
		int maxDiff = arr[1] - arr[0];
		int minVal = arr[0];
		for (int j = 0; j < arr.length; j++) {
			int currDiff = arr[j] - minVal;
			if (maxDiff < currDiff) {
				maxDiff = currDiff;
			}

			if (minVal > arr[j]) {
				minVal = arr[j];
			}
		}
		return maxDiff;
	}
}
