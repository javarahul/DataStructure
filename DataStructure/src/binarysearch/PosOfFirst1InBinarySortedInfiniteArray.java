package binarysearch;

public class PosOfFirst1InBinarySortedInfiniteArray {
	public static void main(String[] args) {
		int[] binaryNum = { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1 };
		int key = 1;

		int pos = findPos(binaryNum, key);

		if (pos >= 0) {
			System.out.println("Item found at first pos:-> " + pos);
		} else {
			System.out.println("Item not available");
		}
	}

	private static int findPos(int[] binaryNum, int key) {
		int start = 0;
		int end = 1;

		while (end < binaryNum.length && key > binaryNum[end]) {
			start = end;
			end = end * 2;
		}
		return binarySearchForFirstPos(binaryNum, key, start, end);
	}

	private static int binarySearchForFirstPos(int[] binaryNum, int key, int start, int end) {
		int res = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (mid < binaryNum.length && key == binaryNum[mid]) {
				res = mid;
				end = mid - 1;
			} else if (mid < binaryNum.length && key < binaryNum[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return res;
	}
}
