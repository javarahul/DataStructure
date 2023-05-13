package geeksforgeeks.practice.array;

public class SecondLargest1 {

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
		int firstLargest = getLargest(arr);
		System.out.println("First largest number is :- " + arr[firstLargest]);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != arr[firstLargest]) {
				if (result == -1) {
					result = i;
				} else {
					if (arr[i] > arr[result]) {
						result = i;
					}
				}
			}
		}
		if (result == -1) {
			return result;
		} else {
			return arr[result];
		}
	}

	public static int getLargest(int arr[]) {
		int largest = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[largest]) {
				largest = i;
			}
		}
		return largest;
	}
}
