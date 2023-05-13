package geeksforgeeks.practice.array;

public class InsertOperation {

	public static void main(String[] args) {
		int arr[] = { 5, 7, 10, 20, -1/*-1 denoting the empty space in array*/ };
		int length = arr.length;
		int currTotalItem = 4;
		int x = 3;
		int pos = 2;
		currTotalItem = insert(arr, length, currTotalItem, x, pos);
		System.out.println("Item added and total count is " + currTotalItem);

		for (int item : arr) {
			System.out.print(item + " ");
		}
	}

	private static int insert(int[] arr, int length, int currTotalItem, int x, int pos) {
		if (length == currTotalItem) {
			System.out.println("Can not add item because array is full");
			return length;
		}

		int idx = pos - 1;
		for (int i = currTotalItem - 1; i >= idx; i--) {
			arr[i + 1] = arr[i];
		}
		arr[idx] = x;
		return currTotalItem + 1;
	}

}
