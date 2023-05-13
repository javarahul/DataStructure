package geeksforgeeks.practice.array;

public class LargestElement2 {

	public static void main(String[] args) {
		int arr[] = { 5, 8, 20, 10 };
		int largest = getLargestElement(arr);
		System.out.println("Largest Element in given array:- " + largest);
	}

	public static int getLargestElement(int arr[]) {
		int result = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[result]) {
				result = i;
			}
		}
		return arr[result];
	}
}
