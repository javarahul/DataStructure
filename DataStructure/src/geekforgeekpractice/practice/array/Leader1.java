package geeksforgeeks.practice.array;

public class Leader1 {

	public static void main(String[] args) {
		int arr[] = { 7, 10, 4, 10, 6, 5, 2 };
		printLeader(arr);
	}

	public static void printLeader(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			boolean flag = true;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] >= arr[i]) {
					flag = false;
					break;
				}
			}

			if (flag) {
				System.out.print(arr[i] + " ");
			}
		}
	}
}
