package growkking.twopointerspattern;

public class SortedArraySquares {

	public static void main(String[] args) {
		int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
		for (int num : result) {
			System.out.print(num + " ");
		}
		System.out.println();

		result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
		for (int num : result) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	private static int[] makeSquares(int[] arr) {
		int squares[] = new int[arr.length];
		int highestIndex = arr.length - 1;
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int leftSquare = arr[left] * arr[left];
			int rightSquare = arr[right] * arr[right];

			if (leftSquare >= rightSquare) {
				squares[highestIndex--] = leftSquare;
				left++;
			} else {
				squares[highestIndex--] = rightSquare;
				right--;
			}
		}
		return squares;
	}
}
