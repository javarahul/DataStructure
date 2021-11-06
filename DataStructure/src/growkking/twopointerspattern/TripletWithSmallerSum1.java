package growkking.twopointerspattern;

public class TripletWithSmallerSum1 {

	public static void main(String[] args) {
		int arr[] = new int[] { 5, 1, 3, 4, 7 };
		int sum = 12;
		System.out.println(countTriplets(arr, sum));
	}

	private static int countTriplets(int[] arr, int targetSum) {
		int tripletCount = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				for (int k = j + 1; j < arr.length; j++) {
					if (arr[i]+arr[j]+arr[k]<targetSum) {
						tripletCount++;
					}
				}
			}
		}
		return tripletCount;
	}
}
