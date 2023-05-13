package geeksforgeeks.practice.array;

public class LargestElement1 {

	public static void main(String[] args) {
		int arr[] = {5,8,20,10};
		int largest = getLargestElement(arr);
		System.out.println("Largest Element in given array:- " + largest);
	}
	
	public static int getLargestElement(int arr[]) {
		for (int i = 0; i<arr.length;i++) {
			boolean flag = true;
			for (int j = 0; j< arr.length;j++) {
				if (arr[j]>arr[i]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				return arr[i];
			}
		}
		return -1;
	}
}
