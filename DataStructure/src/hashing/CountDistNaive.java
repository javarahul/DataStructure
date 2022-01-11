package hashing;

public class CountDistNaive {

	public static void main(String[] args) {
		int arr[] = { 15, 12, 13, 12, 13, 13, 18 };

		int distElement = countDistinct(arr);

		System.out.println("Total distinct Element:- " + distElement);
	}

	private static int countDistinct(int arr[]) {
		int result = 0;

		for (int i = 0; i < arr.length; i++) {
			boolean flag = false;

			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					flag = true;
					break;
				}
			}

			if (!flag) {
				result++;
			}
		}
		return result;
	}
}
