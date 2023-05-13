package geeksforgeeks.practice.array;

public class SecondLargest2 {

	public static void main(String[] args) {
		int arr[] = { 5, 20, 12, 20, 10 };
//		int arr[] = { 10, 10, 10 };
		int result = getSecondLargest(arr);
		if (result > -1) {
			System.out.println("Found Second Largest element as " + result);
		} else {
			System.out.println("Second largest element not present");
		}
	}

	public static int getSecondLargest(int arr[]) {
		int result = -1;
		int largest = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[largest]) {
				result = largest;
				largest = i;
			} else if (arr[i] != arr[largest]) {
				if (result == -1)/* if previously no second largest */ {
					result = i;
				}

				if (arr[i] > arr[result]) /* If we already found second largest */ {
					result = i;
				}
			}
		}
		if (result == -1) {
			return result;
		} else {
			return arr[result];
		}
	}
}
