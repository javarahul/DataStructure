package geeksforgeeks.practice.array;

public class FrequencyInSortedArray1 {

	public static void main(String[] args) {
		int arr[] = { 10, 10, 10, 20, 20, 40, 40, 40, 100 };
		printFrequency(arr);
	}

	public static void printFrequency(int arr[]) {
		int freq = 1;
		int i = 1;
		while (i < arr.length) {
			while (i < arr.length && arr[i] == arr[i - 1]) {
				freq++;
				i++;
			}
			System.out.println(arr[i - 1] + " " + freq);
			freq = 1;
			i++;
		}

		if (arr.length == 1 || arr[arr.length - 2] != arr[arr.length - 1]) {
			System.out.println(arr[arr.length - 1] + " " + 1);
		}
	}
}
