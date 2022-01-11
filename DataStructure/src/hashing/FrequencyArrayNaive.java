package hashing;

public class FrequencyArrayNaive {

	public static void main(String[] args) {
		int arr[] = { 15, 12, 13, 12, 13, 13, 18 };

		printFreq(arr);
	}

	private static void printFreq(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			boolean flag = false;
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					flag = true;
					break;
				}
			}

			if (flag) {
				continue;
			}
			int freq = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					freq++;
				}
			}
			System.out.println(arr[i] + " " + freq);
		}
	}
}
